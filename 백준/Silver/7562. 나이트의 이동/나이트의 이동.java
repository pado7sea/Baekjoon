import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int L; // 체스판 한 변의 길이
    static int[][] graph; // 이동 경로를 저장하는 배열
    static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 }; // 나이트의 이동 방향(행)
    static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 }; // 나이트의 이동 방향(열)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for (int tc = 1; tc <= T; tc++) {

            L = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이
            graph = new int[L][L]; // 이동 경로를 저장하는 배열 초기화
            st = new StringTokenizer(br.readLine());
            int fromX = Integer.parseInt(st.nextToken()); // 시작 위치의 행
            int fromY = Integer.parseInt(st.nextToken()); // 시작 위치의 열

            st = new StringTokenizer(br.readLine());
            int toX = Integer.parseInt(st.nextToken()); // 목표 위치의 행
            int toY = Integer.parseInt(st.nextToken()); // 목표 위치의 열

            bfs(fromX, fromY, toX, toY); // BFS를 사용하여 최단 경로 계산

        } // tc

    }

    private static void bfs(int fromX, int fromY, int toX, int toY) {
        Queue<Point> que = new LinkedList<>(); // BFS에 사용할 큐
        que.add(new Point(fromX, fromY)); // 시작 위치를 큐에 추가
        graph[fromX][fromY] = 0; // 시작 위치의 이동 횟수를 0으로 초기화

        while (!que.isEmpty()) {

            Point node = que.poll(); // 큐에서 노드를 꺼냄

            if (node.getX() == toX && node.getY() == toY) {
                System.out.println(graph[node.getX()][node.getY()]); // 목표 위치에 도달하면 최단 경로 출력
                return;
            }

            for (int d = 0; d < 8; d++) {
                int nr = node.getX() + dr[d]; // 다음 위치의 행 계산
                int nc = node.getY() + dc[d]; // 다음 위치의 열 계산

                if (nr >= 0 && nr < L && nc >= 0 && nc < L && graph[nr][nc] == 0) {
                    // 다음 위치가 체스판 내에 있고 아직 방문하지 않은 곳이라면
                    que.add(new Point(nr, nc)); // 큐에 다음 위치 추가
                    graph[nr][nc] = graph[node.getX()][node.getY()] + 1; // 이동 횟수를 업데이트
                }
            }
        }
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}