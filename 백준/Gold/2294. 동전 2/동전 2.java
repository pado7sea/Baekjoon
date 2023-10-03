import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // n가지 종류의 동전
		int K = Integer.parseInt(st.nextToken()); // 그 가치의 합이 k원이 되도록 하는 최소 동전의 개수

		int[] dp = new int[K + 1];	// 동전의 최소 개수
		int[] arr = new int[N + 1];	// 동전의 종류

		// dp 배열 초기화
		for (int i = 1; i <= K; i++) {
		    dp[i] = Integer.MAX_VALUE-1; // 최대값으로 초기화
		}
		dp[0] = 0; // 0원을 만들 때 필요한 동전 개수는 0개

		// 주어진 동전 가치 배열과 dp 배열의 인덱스는 1부터 시작
		for (int i = 1; i <= N; i++) {
		    arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
		    for (int j = arr[i]; j <= K; j++) {
		        dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
		    }
		}

		if (dp[K] == Integer.MAX_VALUE-1) {
		    System.out.println(-1);
		} else {
		    System.out.println(dp[K]);
		}

	}
}