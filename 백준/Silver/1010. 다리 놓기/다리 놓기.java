import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int[][] dp = new int[30][30];

        for (int i = 1; i < 30; i++) {
            for (int j = i; j < 30; j++) {
                if(i==j){
                    dp[i][j] = 1;
                }else if(i==1) {
                    dp[i][j] = j;
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(dp[N][M]);
        }//tc

    }
}