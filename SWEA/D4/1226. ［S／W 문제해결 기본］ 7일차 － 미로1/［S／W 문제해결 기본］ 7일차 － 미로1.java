import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static int N;
	static int[][] maze;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int res = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int dummy = Integer.parseInt(br.readLine());
			N = 16;
			maze = new int[N][N]; // 미로배열
			visited = new boolean[N][N]; // 방문여부체크배열

			int startX = -1, startY = -1;

			// 배열에 미로 정보 입력
			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < N; j++) {
					maze[i][j] = tmp.charAt(j) - '0';

					// 출발점
					if (maze[i][j] == 2) {
						startX = i;
						startY = j;
					}
				}
			}
			res = 0;
			dfs(startX, startY);

			System.out.println("#" + tc + " " + res);
		} // tc

	}// main

	public static void dfs(int startX, int startY) {

		if (maze[startX][startY] == 3) {
			res = 1;
			return;
		}
		
		visited[startX][startY] = true;

		for (int d = 0; d < 4; d++) {
			int nx = startX + dx[d];
			int ny = startY + dy[d];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && maze[nx][ny] != 1) {
				dfs(nx, ny);
			}

		}
	}
}