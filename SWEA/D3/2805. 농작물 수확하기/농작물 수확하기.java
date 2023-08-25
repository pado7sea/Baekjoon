import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 입력
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = temp.charAt(j) - '0';
				}
			}
			int ans = 0; // 수확한 농작물의 가치

//			// 방법 1 : 위쪽 삼각형 + 아래쪽 삼각형
//			int mid = N / 2;
//			// 위쪽 삼각형
//			for (int i = 0; i <= mid; i++) {
//				for (int j = mid - i; j <= mid + i; j++) {
//					ans += farm[i][j];
//				}
//			}
//			//아래쪽 삼각형
//			for (int i = mid + 1; i < N; i++) {
//				for (int j = i - mid; j < N - i + mid; j++) {
//					ans += farm[i][j];
//				}
//			}
//
			// 방법 2
			int mid = N / 2;
			int step = 0;
			for (int i = 0; i < N; i++) {
				for (int j = mid - step; j <= mid + step; j++) {
					ans += farm[i][j];
				}
				if (i < mid)
					step++; // 끝점을 양옆으로 하나씩 증가
				else
					step--; // 끝점을 하나씩 감소
			}

//			// 방법3(중심부터 농작물까지의 거리가 다 같음을 이용. 정사각배열일때만 가능)
//			int mid = N / 2;
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if (Math.abs(i - mid) + Math.abs(j - mid) <= mid) {
//						ans += farm[i][j];
//					}
//				}
//			}

			System.out.println("#"+tc+" "+ans);

		} // tc
	}// main
}