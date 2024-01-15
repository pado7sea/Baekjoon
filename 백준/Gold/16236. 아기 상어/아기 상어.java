import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, shark, totalFish;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        shark = 2;
        int startX = 0, startY = 0;
        totalFish = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 9) {
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
                if (num > 0 && num < 9) {
                    totalFish++;
                }
            }
        }
        bfs(startX, startY);


    }

    private static void bfs(int startX, int startY) {
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(startX, startY, 0));
        visited[startX][startY] = true;

        int time = 0; // 시간
        int eatCount = 0; // 먹은 물고기 수

        while (!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;

            // 먹을 수 있는 물고기를 찾았을 때
            if (map[x][y] != 0 && map[x][y] < shark) {
                map[x][y] = 0; // 물고기 먹음
                eatCount++;
                if (eatCount == shark) {
                    shark++;
                    eatCount = 0;
                }

                // 먹고나서 상어 크기 커졌으니까 다시 탐색해야함
                visited = new boolean[N][N];
                visited[x][y] = true;
                time += p.distance; // 총 시간 추가
                p.distance = 0;
                // 다시 bfs 돌려야하니까 큐 비우고 현재위치부터 다시 bfs 시작
                q.clear();
                q.add(new Point(x,y,0));
            }


            // 사방탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 배열 밖이면 패스
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] <= shark) {
                    q.add(new Point(nx, ny, p.distance + 1));
                    visited[nx][ny] = true;
                }

            }

        }

        System.out.println(time);

    }
}

class Point implements Comparable<Point> {
    int x, y, distance;

    public Point(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override
    public int compareTo(Point o) {
        if (this.distance == o.distance) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
        return this.distance - o.distance;
    }
}