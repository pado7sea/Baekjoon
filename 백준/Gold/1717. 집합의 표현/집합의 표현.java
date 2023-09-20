import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] p; // 대표를 저장할 배열

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
		StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());// 정점의 개수 
			int m = Integer.parseInt(st.nextToken());// 연산의 개수

			p = new int[n+1]; // 정점은 1부터 시작
			
			// make-set
			for (int i = 0; i <= n; i++) {
				p[i] = i;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int case0or1 = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (case0or1 == 0) {
					// 합집합
					union(a, b);
					
				} else {
					// 두 원소가 같은 집합에 포함되어 있는지 확인
					if(findset(a) == findset(b)) {
						System.out.println("YES");
					}else {
						System.out.println("NO");
					}
				}
			}
	}// main
}