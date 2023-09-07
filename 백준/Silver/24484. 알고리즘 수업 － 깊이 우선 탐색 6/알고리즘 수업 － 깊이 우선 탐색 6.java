import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph; // 그래프를 표현하기 위한 배열
	static int[] visited; // 정점 깊이를 저장하는 배열
	static int[] order; // 정점 방문 순서를 저장하는 배열
	static int count; // 정점 방문 순서
	static long sum; // 깊이*방문순서 의 합
	
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

		// 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}

		// 방문 여부를 나타내는 배열 초기화
		visited = new int[N + 1];
		order = new int[N + 1];
		Arrays.fill(visited, -1); // 방문 되지 않는 노드의 깊이는 -1
		visited[R] = 0; // 시작 정점 R의 깊이는 0
		count = 1; // 시작 정점 방문 순서는 1

		// DFS 호출
		dfs(R, 0);

		// 결과 출력
		sb.append(sum);
		System.out.println(sb);
	}

	// 깊이 우선 탐색(DFS) 함수
	static void dfs(int node, int depth) {
		// 현재 정점를 방문 표시. 깊이를 visited배열에, 방문 순서를 order배열에 저장한다.
		visited[node] = depth;
		order[node] = count;
		sum += (long) depth*count;
		count++;

		// for-each로 현재 정점과 연결된 인접 정점들에 대해 DFS 재귀 호출
		for (int nearNode : graph[node]) {
			if (visited[nearNode] == -1) {
				dfs(nearNode, depth + 1);
			}
		}
	}
}