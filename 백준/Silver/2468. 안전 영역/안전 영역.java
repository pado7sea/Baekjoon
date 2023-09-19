import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] cheese;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        cheese = new int[N][N];
        int maxDay = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                maxDay = Math.max(maxDay, cheese[i][j]);
            }
        }

        int max = 0;

        for (int k = 0; k < maxDay; k++) {
            int count = 0;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (cheese[i][j] == k) {
                        cheese[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && cheese[i][j] != 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    public static void dfs(int startX, int startY) {
        visited[startX][startY] = true;

        for (int d = 0; d < 4; d++) {
            int nx = startX + dx[d];
            int ny = startY + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && cheese[nx][ny] != 0) {
                dfs(nx, ny);
            }
        }
    }
}