import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); 
		int[][] dp = new int[41][2]; // N은 40보다 작거나 같은 자연수 또는 0

		// 초기값
		dp[0][0] = 1; // 0의 0 출력 횟수
		dp[0][1] = 0; // 0의 1 출력 횟수

		dp[1][0] = 0; // 1의 0 출력 횟수
		dp[1][1] = 1; // 1의 1 출력 횟수

		for (int i = 2; i <= 40; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0]; // i번째 숫자의 0 출력 횟수
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1]; // i번째 숫자의 1 출력 횟수
		}

		//미리 디피 배열에 저장해놓고 그 다음에 저장해놓은 거에서 테케 찾아서 값 가지고 와
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N][0]+" "+dp[N][1]);
		}
	}
}