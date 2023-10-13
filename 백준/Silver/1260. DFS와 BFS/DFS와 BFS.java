import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		V = Integer.parseInt(st.nextToken()); // 시작 정점 번호

		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph[A].add(B);
			graph[B].add(A);

		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[N + 1];
		dfs(0, V);
		
		System.out.println();
		
		visited = new boolean[N + 1];
		bfs(V);

	}

	private static void dfs(int depth, int current) {
		if (depth == N) {
			return;
		}

		System.out.print(current + " ");
		visited[current] = true;

		for (int x : graph[current]) {
			if (!visited[x]) {
				dfs(depth + 1, x);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int current = q.poll();
			System.out.print(current+" ");
			for (int x : graph[current]) {
				if(!visited[x]) {
					q.add(x);
					visited[x] = true;					
				}
			}
		}
	}
}