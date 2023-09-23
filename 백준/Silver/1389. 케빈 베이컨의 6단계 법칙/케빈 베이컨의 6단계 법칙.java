import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] graph;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 처리
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람의 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        graph = new int[N + 1][N + 1]; // 친구 관계를 나타내는 그래프
        visited = new int[N + 1]; // 방문 여부 및 케빈 베이컨 수를 저장하는 배열

        // 친구 관계 입력 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 양방향 친구 관계를 그래프에 저장
            graph[A][B] = 1;
            graph[B][A] = 1;
        }

        int min = Integer.MAX_VALUE;
        int res = 0;

        // 모든 사람에 대해 케빈 베이컨 수 계산 및 최솟값 찾기
        for (int i = 1; i <= N; i++) {
            visited = new int[N + 1]; // 케빈 베이컨 수 계산을 위해 visited 배열 초기화
            int kb = bfs(i); // i번 사람의 케빈 베이컨 수 계산
            if (min > kb) {
                min = kb;
                res = i; // 최솟값 업데이트 및 해당 사람 저장
            }
        }
        System.out.println(res); // 최소 케빈 베이컨 수를 가진 사람 출력
    }

    // BFS를 사용하여 케빈 베이컨 수 계산
    private static int bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = 1;

        while (!que.isEmpty()) {
            int node = que.poll();

            for (int i = 1; i <= N; i++) {
                // 친구 관계가 있고 방문하지 않았다면 큐에 추가하고 깊이 업데이트
                if (graph[node][i] == 1 && visited[i] == 0) {
                    que.add(i);
                    visited[i] = visited[node] + 1;
                }
            }
        }

        int kevinBacon = 0;

        for (int i = 1; i <= N; i++) {
            if (i == start) { // 시작 노드의 경우 제외
                continue;
            }
            kevinBacon += visited[i]; // 케빈 베이컨 수를 합산
        }
        return kevinBacon;
    }
}