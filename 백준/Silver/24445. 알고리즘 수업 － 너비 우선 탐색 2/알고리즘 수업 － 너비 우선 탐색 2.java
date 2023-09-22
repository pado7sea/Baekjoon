import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static List<Integer>[] graph;
	static int[] visited;
	static int order;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 수
		M = Integer.parseInt(st.nextToken()); // 간선의 수
		R = Integer.parseInt(st.nextToken()); // 시작 정점

		graph = new ArrayList[N + 1]; // 인접리스트
		visited = new int[N + 1]; // 방문 순서를 저장할 배열

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

		// 각 정점의 인접 리스트를 내림차순으로 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}

		// BFS 수행
		order = 0; // 방문 순서
		bfs(R);

		// 방문 순서 출력
		for (int i = 1; i <= N; i++) {
			System.out.println(visited[i]);
		}

	}// main

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();

		order = 1;
		visited[start] = order;
		queue.add(start);

		while (!queue.isEmpty()) {

			int current = queue.poll();
			for (int x : graph[current]) {
				if (visited[x] == 0) {// 아직 방문하지 않은 이웃 노드를 만나면
					order++;
					visited[x] = order; // 방문 순서 기록
					queue.add(x);// 큐에 추가하여 나중에 탐색
				}
			}

		}
	}
}