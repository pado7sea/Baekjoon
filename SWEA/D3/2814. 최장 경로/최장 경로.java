import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N, M;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			graph = new ArrayList[N + 1];
			visited = new boolean[N + 1];

			for (int i = 0; i < N + 1; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				graph[x].add(y);
				graph[y].add(x);
			}

			max = 0;
			for (int i = 1; i < N + 1; i++) {
				dfs(i, 1);
			}

			System.out.println("#" + tc + " " + max);

		} // tc

	}// main

	public static void dfs(int node, int distance) {
		visited[node] = true;
		max = Math.max(max, distance);

		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next, distance + 1);
			}
		}
		visited[node] = false;
	}
}