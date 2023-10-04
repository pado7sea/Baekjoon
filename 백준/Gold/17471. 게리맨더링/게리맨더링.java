import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N; // 구역의 개수
    static int[] population; // 각 구역의 인구 정보를 저장하는 배열
    static int[] area; // 각 지역이 어느 선거구에 속하는지 나타냄. (1 or 2번 선거구)
    static ArrayList<Integer>[] adjList; // 인접한 구역의 정보를 담는 인접 리스트
    static boolean[] visited; // DFS에서 방문 여부를 저장하는 배열
    static int min = Integer.MAX_VALUE; // 최소 인구 차이를 저장하는 변수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 구역의 개수 입력
        population = new int[N + 1]; // 각 구역의 인구를 저장할 배열 초기화
        adjList = new ArrayList[N + 1]; // 인접한 구역의 정보를 담을 인접 리스트 배열 초기화

        st = new StringTokenizer(br.readLine()); // 각 구역의 인구 입력
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>(); // 각 지역의 인접 리스트 초기화
            population[i] = Integer.parseInt(st.nextToken()); // 각 지역의 인구 입력
        }

        // 지역 간 연결 정보 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 해당 구역과 인접한 구역의 수
            for (int j = 1; j <= M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                adjList[i].add(tmp); // 현재 구역과 인접한 구역 정보를 인접 리스트에 추가
            }
        }

        area = new int[N + 1]; // 각 지역이 어느 선거구에 속하는지 나타냄. (1 or 2번 선거구)
        dfs(1); // 모든 지역구 분할을 시도하는 DFS 탐색

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1); // 선거구를 나눌 수 없는 경우 -1 출력
        } else {
            System.out.println(min); // 최소 인구 차이 출력
        }
    }

    // DFS를 사용하여 가능한 모든 선거구 분할을 시도하는 함수
    private static void dfs(int depth) {
        if (depth == N + 1) { // N+1지역까지 선거구를 나눴다면

            int area1 = 0; // 1번 선거구의 인구 수
            int area2 = 0; // 2번 선거구의 인구 수

            for (int i = 1; i <= N; i++) {
                if (area[i] == 1)
                    area1 += population[i];
                else
                    area2 += population[i];
            }

            visited = new boolean[N + 1];
            int part = 0; // 연결된 지역들로 구성된 무리(연결된 구성 요소)의 총 수를 저장

            for (int i = 1; i <= N; i++) {
                if (visited[i])
                    continue;

                bfs(i); // 연결된 지역을 모두 방문표시하는 BFS 탐색
                part++;
            }

            // 무리가 총 2개일 때 (= 지역이 2개로 나뉘어졌을 때), 두 지역의 인구수 차이 계산
            if (part == 2) {
                min = Math.min(min, Math.abs(area1 - area2));
            }

            return;
        }

        // 부분집합인데 공집합을 제외하기 위해 1부터 시작해서, 무조건 1지역이 1번이나 2번에 들어가는 걸로 시작함
        area[depth] = 1; // depth번째 지역을 1번 선거구에 할당
        dfs(depth + 1); // 다음 지역

        area[depth] = 2; // depth번째 지역을 2번 선거구에 할당
        dfs(depth + 1); // 다음 지역

    }

    // BFS를 사용하여 연결된 지역들을 방문표시하는 함수
    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        que.add(start);

        while (!que.isEmpty()) {
            int node = que.poll();
            for (int near : adjList[node]) {
                // 현재 노드와 인접한 지역이 시작노드와 같은 선거구이고 방문한 적이 없었다면
                if (area[near] == area[start] && !visited[near]) {
                    que.add(near);
                    visited[near] = true;
                }
            }
        }
    }
}