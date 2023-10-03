import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 1000 - Integer.parseInt(br.readLine()); // 거스름돈

        int[] dp = new int[N + 1]; // 거스름돈을 만들기 위한 동전의 최소 개수를 저장하는 배열
        int[] arr = { 500, 100, 50, 10, 5, 1 }; // 사용 가능한 동전의 가치

        Arrays.fill(dp, Integer.MAX_VALUE - 1); // dp 배열을 최대값으로 초기화 (Integer.MAX_VALUE-1은 무한대를 나타냄)
        dp[0] = 0; // 0원을 만들기 위한 동전 개수는 0개

        // 각각의 동전 가치에 대해 최소 동전 개수를 계산
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j <= N; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                // dp[j]: 현재 금액 j를 만들기 위한 최소 동전 개수
                // dp[j - arr[i]] + 1: 현재 금액 j에서 현재 동전 가치(arr[i])를 뺀 금액을 만들기 위한 동전 개수에 1을 더함
                // 위 둘 중에서 작은 값을 선택하여 dp[j]에 저장
            }
        }
        System.out.println(dp[N]); // N원을 만들기 위한 최소 동전 개수를 출력
    }
}