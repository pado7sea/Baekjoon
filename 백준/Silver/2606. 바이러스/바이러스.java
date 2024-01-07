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

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

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

		visited[node] = true;
		
		for(int adj : adjList[node]) {
			if(!visited[adj]) {
				dfs(adj);
				count++;
			}
		}
	}
}