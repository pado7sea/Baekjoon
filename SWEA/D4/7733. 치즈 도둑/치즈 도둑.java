import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] cheese;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 치즈의 한 변의 길이

			cheese = new int[N][N]; // 치즈배열

			// 치즈 배열에서 제일 큰 수
			int maxDay = 0;

			// 배열에 치즈 정보 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(maxDay, cheese[i][j]);
				}
			}

			// 치즈 덩어리의 최대 개수
			int max = 0;

			// 치즈 배열에서 제일 큰 수만큼 포문 돌려
			for (int k = 0; k < maxDay; k++) {
				int count = 0; // 치즈 덩어리의 개수
				visited = new boolean[N][N]; // 방문여부체크배열 초기화

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						// k번째 날이면 맛있는 정도가 k인 칸을 0으로 바꾼다
						if (cheese[i][j] == k) {
							cheese[i][j] = 0;
						}
						
					}
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						// 방문한 적 없고, 0이 아닌 칸이 나오면 dfs
						if (!visited[i][j] && cheese[i][j] != 0) {
							dfs(i, j);
							count++;
						}
						
					}
				}
				
				
				max = Math.max(max, count);

			}
			System.out.println("#" + tc + " " + max);

		} // tc

	}// main

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