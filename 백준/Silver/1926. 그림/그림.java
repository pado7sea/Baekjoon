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
	static int size;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 배추밭 가로길이
		M = Integer.parseInt(st.nextToken()); // 배추밭 세로길이

		graph = new int[N][M]; // 그래프구조를 위한 배열 초기화
		visited = new boolean[N][M]; // 방문 여부 체크 배열 초기화

		// 그래프 배열에 그림들의 위치 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0; // 그림 수
		int max = 0; // 그림의 최대 사이즈

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				size = 0; // 그림 사이즈 초기화

				// 방문하지 않았던 1이 등장할 때마다
				if (graph[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true; // 방문표시하고
					count++; // 그림 수 +1
					size++; // 그림의 사이즈 +1
					dfs(i, j); // dfs를 통해 그 주변 1들을 싹 다 방문 표시
					max = Math.max(max, size);
				}
			}
		}

		System.out.println(count+"\n"+max);
	}// main

	public static void dfs(int row, int col) {

		for (int d = 0; d < 4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
				continue;
			}

			// 다음자리가 범위 내이고, 1이라면
			if (graph[nr][nc] == 1 && !visited[nr][nc]) {
				visited[nr][nc] = true; // 방문 표시하고
				size++; // 그림 사이즈 +1
				dfs(nr, nc);
			}
		}
	}
}