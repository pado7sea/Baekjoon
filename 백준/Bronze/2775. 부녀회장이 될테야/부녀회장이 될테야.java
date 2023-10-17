import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int K = Integer.parseInt(br.readLine());

			int[][] dp = new int[15][15]; //1 ≤ k, n ≤ 14

			// 초기화(0층 i호는 i명)
			for (int i = 1; i <= K; i++) {
				dp[0][i] = i;
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= K; j++) {
					// 1층 3호는 1층 2호 더하기 0층 3호
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				}
			}
			System.out.println(dp[N][K]);
		}
	}
}