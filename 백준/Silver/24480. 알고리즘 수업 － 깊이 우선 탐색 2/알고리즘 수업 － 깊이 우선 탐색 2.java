import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph; // 그래프를 표현하기 위한 배열
	static int[] visited; // 정점 방문 순서를 저장하는 배열
	static int count; // 방문 순서

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 정점의 수
		int M = Integer.parseInt(st.nextToken()); // 간선의 수
		int R = Integer.parseInt(st.nextToken()); // 시작 정점

		// 그래프 초기화: 각 정점에 인접한 정점들을 저장하기 위한 ArrayList 배열
		graph = new ArrayList[N + 1]; // 1번부터 N번까지 인덱스를 사용하기 위해 배열 크기를 N+1로 설정
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		// 간선 정보 입력 ( 현재 인덱스 : 정점, 인덱스의 값 : 정점과 인접한 정점들)
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u); // 양방향 간선이기 때문에 반대방향으로도 간선을 연결해 줌
		}

		// 방문 여부를 나타내는 배열 초기화
		visited = new int[N + 1];
		count = 1;

		// 정렬 : 정점 번호를 내림차순으로 방문
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}

		// DFS 호출
		dfs(R);

		// 결과 출력
		for (int i = 1; i <= N; i++) {
			sb.append(visited[i]).append("\n"); // 시작 정점 R에서 도달한 정점은 해당 정점 번호 출력
		}
		System.out.println(sb);
	}

	// 깊이 우선 탐색(DFS) 함수
	static void dfs(int node) {
		// 현재 정점를 방문 표시. 방문한 순서를 visited배열에 저장한다.
		visited[node] = count;

		// for-each로 현재 정점과 연결된 인접 정점들에 대해 DFS 재귀 호출
		for (int nearNode : graph[node]) {
			if (visited[nearNode] == 0) {
				count++;
				dfs(nearNode);
			}
		}
	}
}