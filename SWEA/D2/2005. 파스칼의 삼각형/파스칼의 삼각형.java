import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 배열 크기
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if (j == 0 || i == j) { // 파스칼 삼각형의 바깥쪽 1
						arr[i][j] = 1;
					}else {
						arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
					}
				}
			}
			
			//출력
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
	}
}