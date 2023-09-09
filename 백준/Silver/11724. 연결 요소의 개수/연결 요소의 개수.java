import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수

		graph = new ArrayList[N + 1]; // 그래프구조를 위한 배열 초기화
		visited = new boolean[N + 1]; // 방문 여부 체크 배열 초기화

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();// 각 정점에 대한 인접 리스트 초기화
		}

		// 양방향 연결 그래프
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // 연결된 정점 u
			int v = Integer.parseInt(st.nextToken()); // 연결된 정점 v

			graph[u].add(v); // u와 v를 연결
			graph[v].add(u); // v와 u를 연결 (양방향 연결)
		}

		int count = 0; // 연결 요소의 개수 초기화

		// 연결 요소 개수 구하는 법
		// 특정 정점에 방문한 흔적이 없다면, 이 정점이 현재 연결 요소의 시작점이라는 의미
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i); // DFS를 이용하여 연결된 정점들을 탐색하고 방문 완료 처리
				count++; // 연결 요소 개수 증가
			}
		}
		System.out.println(count); // 연결 요소의 개수 출력

	}

	// node 와 연결되어있는 정점들을 모두 방문 완료 처리를 한다.
	public static void dfs(int node) {
		for (int near : graph[node]) {
			if (!visited[near]) {
				visited[near] = true; // 방문 표시
				dfs(near); // 연결된 정점에 대해서도 DFS를 재귀적으로 호출
			}
		}
	}
}