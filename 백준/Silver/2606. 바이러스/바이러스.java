import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int count; // 바이러스에 감염시킨 컴퓨터의 수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수(정점의 수)
		M = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수(간선의 수)

		adjList = new ArrayList[N + 1];
		visited = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
		
			adjList[A].add(B);
			adjList[B].add(A);
		}
		
		count = 0;
		dfs(1);
		System.out.println(count);

	}

	private static void dfs(int node) {
		//방문표시
		visited[node] = true;
		
		//현재 노드와 연결되어있고 방문한 적 없는 인접 노드들에 대해 dfs 실행
		for(int adj : adjList[node]) {
			if(!visited[adj]) {
				dfs(adj);
				count++; //감염시킨 컴퓨터의 수 1 증가
			}
		}
	}
}