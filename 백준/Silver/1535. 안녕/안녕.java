import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] health = new int[N + 1];
        int[] joy = new int[N + 1];
        int[][] dp = new int[N + 1][101];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            health[i] = Integer.parseInt(st.nextToken()); // 잃는 체력
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            joy[i] = Integer.parseInt(st.nextToken()); // 얻는 기쁨
        }

        for (int i = 1; i <= N; i++) {
            // 체력이 0일 때의 최대기쁨부터 체력이 99일때의 최대기쁨까지 구해나감
            for (int j = 0; j <= 100; j++) {
                if (health[i] < j) {
                    // 이전값 vs. 이전값에서 현재사람 체력을 뺐을 때의 값 + 기쁨
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - health[i]] + joy[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                max = Math.max(max, dp[i][j]);
            }

        }
        System.out.println(max);

    }
}