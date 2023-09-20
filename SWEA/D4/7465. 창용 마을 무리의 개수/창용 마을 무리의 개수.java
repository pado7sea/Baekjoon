import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static int[] p; 

	static int findset(int x) {
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}

	static void union(int x, int y) {
		p[findset(y)] = findset(x); // x의 대표를 y의 대표로 넣겠다. rank고려x
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());	// 정점의 개수
			int m = Integer.parseInt(st.nextToken());	// 연산의 개수

			p = new int[n + 1];	// 대표를 저장할 배열. 정점은 1부터 시작

			//make-set
			for (int i = 1; i <= n; i++) {
				p[i] = i; 
			}

			//서로 아는 관계들을 다 합해서 전체 무리 관계도를 만든다
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b); 
			}
			
			//각 무리의 대표들을 set에 저장한다(중복없이 저장되기 때문에 set의 크기가 무리의 개수가 된다.)
			Set<Integer> set = new HashSet<>();
			for(int i =1 ; i<=n;i++) {
				set.add(findset(p[i]));
			}
			
			sb.append("#" + tc + " " + set.size() + "\n");

		} // tc
		 System.out.println(sb);
	}// main
}