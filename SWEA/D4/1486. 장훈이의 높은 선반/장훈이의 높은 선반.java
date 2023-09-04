import java.util.Scanner;

public class Solution {
	static int N, B, ans;
	static int[] H;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			H = new int[N];
			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			}
			ans = Integer.MAX_VALUE;
			powerset(0,0);
			System.out.println("#" + tc + " " + (ans - B));
		} // tc

	}// main

	public static void powerset(int idx, int sum) {
		if (sum > ans) //ans가 이미 더 작은 값이라면 밑에 있는 if문을 실행할 필요가 없으니까ㅇㅇ
			return;

		if (idx == N) {
			if (sum >= B) {
				ans = Math.min(ans, sum);
			}
			return;
		}

		powerset(idx + 1, sum + H[idx]);
		powerset(idx + 1, sum);

	}
}