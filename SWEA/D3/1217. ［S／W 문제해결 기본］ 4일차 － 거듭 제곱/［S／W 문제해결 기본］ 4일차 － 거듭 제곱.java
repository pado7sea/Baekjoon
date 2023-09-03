import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static int res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			String dummy = br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			res = 1;
			
			function(0);

			System.out.println("#" + tc + " " + res);
		}
	}// main

	public static void function(int count) {

		if(count == M) {
			return;
		}
		res = res * N;
		function(count+1);
	}
}