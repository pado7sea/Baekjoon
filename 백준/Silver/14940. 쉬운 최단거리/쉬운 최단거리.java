import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] map;
	static int[][] target;
	static boolean[][] visited;
	static Queue<int[]> que;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int x = -1, y = -1; // 시작 지점 좌표
		map = new int[n][m];
		target = new int[n][m]; // 목표 지점까지의 거리를 저장할 배열

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					x = i;
					y = j;
				}else if(map[i][j]==1) {
					target[i][j] = -1;
				}
			}
		}
		// 시작 지점의 큐에 추가하고 거리를 0으로 설정

		
		bfs(x,y);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(target[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}// main

	public static void bfs(int targetX, int targetY) {
		que = new LinkedList<>();
		que.add(new int[] { targetX, targetY });
		
		while (!que.isEmpty()) {
			int[] current = que.poll();
			int x = current[0];
			int y = current[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && target[nx][ny] == -1) {
					que.add(new int[] { nx, ny });
					target[nx][ny] = target[x][y] + 1;
				}
			}
		}

	}
}