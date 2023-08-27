import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {

			// 테이블의 크기
			int n = Integer.parseInt(br.readLine());
			// 테이블에 올려진 자성체 배열
			int[][] table = new int[n][n];
			// 배열 입력
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 충돌 횟수
			int boom = 0;

			// 열 별로 순회하면서 N이 나오면 true로 바꾸고 그 아래에 S가 나오면 충돌횟수를 증가시키고, false로 바꾼다.
			for (int j = 0; j < n; j++) {
				
				// N과 S의 존재를 체크하는 변수
				boolean check = false;
				
				for (int i = 0; i < n; i++) {
					if(table[i][j] == 1) {
						check = true;
					}
					if(check && table[i][j]==2) {
						boom++;
						check = false;
					}
				}
			}
			System.out.println("#"+tc+" "+boom);

		} // tc
	}// main
}