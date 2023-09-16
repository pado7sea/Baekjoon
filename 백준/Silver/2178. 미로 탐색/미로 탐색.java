import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M; // 미로의 행과 열 크기
    static int[][] maze; // 미로 정보를 저장하는 배열
    static int[][] visited; // 방문 여부와 거리 정보를 저장하는 배열
    static int[] dx = { -1, 1, 0, 0 }; // 상하좌우 방향으로 이동하기 위한 배열
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행 크기 입력
        M = Integer.parseInt(st.nextToken()); // 열 크기 입력

        maze = new int[N + 1][M + 1]; // 미로 정보 배열
        visited = new int[N + 1][M + 1]; // 방문 여부와 거리 정보 배열

        // 미로 정보 입력
        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= M; j++) {
                maze[i][j] = temp.charAt(j - 1) - '0'; // 문자열을 정수로 변환하여 저장
            }
        }

        // 시작점(1, 1)에서 BFS 실행하고 결과 출력
        System.out.println(bfs(1, 1));
    }

    // BFS 알고리즘으로 최단 경로를 찾는 메서드
    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y }); // 시작점을 큐에 추가
        visited[x][y] = 1; // 시작점 방문 표시

        while (!queue.isEmpty()) {
            int[] u = queue.poll(); // 큐에서 하나의 위치를 꺼냄
            int ux = u[0];
            int uy = u[1];

            // 상하좌우로 이동
            for (int d = 0; d < 4; d++) {
                int nx = ux + dx[d];
                int ny = uy + dy[d];

                // 이동한 위치가 미로 내에 있고, 이동 가능하며 아직 방문하지 않았다면
                if (nx > 0 && nx <= N && ny > 0 && ny <= M && maze[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[ux][uy] + 1; // 거리 정보 업데이트
                    queue.add(new int[] { nx, ny }); // 다음 위치를 큐에 추가

                    // 목적지에 도달했다면 거리를 반환
                    if (nx == N && ny == M) {
                        return visited[nx][ny];
                    }
                }
            }
        }
        return 0; // 목적지에 도달하지 못한 경우
    }
}