import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, A, B;
	static List<Integer>[] graph;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 정점의 수

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken()); // 거리를 계산해야하는 두 정점
		B = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine()); // 간선의 수

		graph = new ArrayList[N + 1]; // 인접리스트
		visited = new int[N + 1]; // 거리 저장할 배열

		// 각 정점의 인접 리스트 초기화
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		// 그래프에 간선 정보 추가
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[x].add(y);
			graph[y].add(x); // 무방향 그래프
		}

		// BFS 수행
		int result = bfs(A, B);
		System.out.println(result);

	}// main

	private static int bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();

		visited[start] = 1;
		queue.add(start);

		while (!queue.isEmpty()) {
			// 큐에서 현재 노드를 가져옴
			int current = queue.poll();

			// 만약 노드가 목표 노드 B와 같다면, 거리-1을 리턴
			if (current == B) {
				return visited[current] - 1;
			}
			// 현재 노드와 연결된 모든 이웃 노드를 반복하면서 처리
			for (int x : graph[current]) {

				// 이웃 노드를 아직 방문하지 않았다면, 이전 노드의 거리에 1을 더한 값을 visited 배열에 저장하고 큐에 추가
				if (visited[x] == 0) {
					visited[x] = visited[current] + 1;
					queue.add(x);
				}
			}
		}

		// 두 정점 사이에 경로가 없으면 -1 리턴
		return -1;
	}
}