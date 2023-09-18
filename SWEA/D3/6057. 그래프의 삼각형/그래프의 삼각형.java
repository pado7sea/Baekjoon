import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[N + 1];

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
			
			int count = 0; // 삼각형의 개수
			
			for(int i = 1; i < N+1; i++) {
				if(graph[i] != null) {
					
					//i번 정점에 연결되어있는 j번 정점
					for(int j : graph[i]) {
						//j번 정점에 연결되어있는 k번 정점
						for(int k : graph[j]) {
							//k번 정점에 연결되어있는 l번 정점
							for(int l : graph[k]) {
								if(l==i) count++;
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+count/6);
		} // tc
	}
}