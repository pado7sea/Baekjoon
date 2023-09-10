import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int M, N, K;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테케
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 배추밭 가로길이
			N = Integer.parseInt(st.nextToken()); // 배추밭 세로길이
			K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

			graph = new int[M][N]; // 그래프구조를 위한 배열 초기화
			visited = new boolean[M][N]; // 방문 여부 체크 배열 초기화

			// 그래프에 배추의 위치 입력
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x][y] = 1;
			}

			int count = 0; // 배추흰지렁이 마리 수

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						count++; // 방문하지 않았던 1이 등장할 때마다 지렁이 수 +1
						dfs(i, j);
					}
				}
			}

			System.out.println(count);
		} // tc
	}// main

	public static void dfs(int row, int col) {

		for (int d = 0; d < 4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];

			if (nr < 0 || nr >= M || nc < 0 || nc >= N) {
				continue;
			}

			if (graph[nr][nc] == 1 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}

		}

	}
}