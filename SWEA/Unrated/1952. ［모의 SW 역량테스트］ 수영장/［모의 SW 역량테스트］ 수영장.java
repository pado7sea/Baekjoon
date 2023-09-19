import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] cost;
    static int[] month;
    static int minCost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            cost = new int[4]; // 1일, 1달, 3달, 1년 이용권
            month = new int[13]; // 각 달의 이용계획

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < 13; i++) {
                month[i] = Integer.parseInt(st.nextToken());
            }

            minCost = cost[3]; // 최소 비용을 1년 이용권의 요금으로 초기화

            plan(1, 0);

            System.out.println("#" + tc + " " + minCost);

        } // tc

    }// main

    // 이용 계획을 짜는 재귀 함수
    public static void plan(int m, int sum) {

        // 이용권 비용이 최소 비용보다 커지면 더 이상 재귀 돌릴 필요가 없음.
        if (sum >= minCost) {
            return;
        }

        if (m > 12) {
            minCost = Math.min(minCost, sum);
            return;
        }

        if (month[m] == 0) {
            plan(m + 1, sum);
        } else {

            // 1일 이용권 사용
            plan(m + 1, sum + cost[0] * month[m]);

            // 1달 이용권 사용
            plan(m + 1, sum + cost[1]);

            // 3달 이용권 사용
            plan(m + 3, sum + cost[2]);

        }
    }
}