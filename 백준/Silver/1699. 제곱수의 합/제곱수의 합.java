
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = i; // // 1을 i번 더했을 때가 최대니까 최대값으로 초기화
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1); // 이전에 나왔던 숫자의 조합으로 가능한 것들 중에서 제일 작은 거
                // dp[0] = 0 이라서 i==j*j이면 dp[i] = 1이 된다.
                // dp[제곱수]=1, dp[제곱수+1] = dp[1], dp[제곱수+2] = dp[2] 의 규칙을 활용한 식
            }
        }
        System.out.println(dp[N]);
    }
}