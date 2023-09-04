import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, B; // 점원 수(N), 선반 높이(B)를 저장하는 변수
	static int[] heights; // 각 점원의 키를 저장하는 배열
	static int min; // 높이 차이의 최소값을 저장하는 변수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			heights = new int[N];
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			powerset(0, 0, 0);
			System.out.println("#" + tc + " " + (min - B));

		} // tc

	}// main

	// currentHeight : 현재 직원들의 키의 합
	// remainHeight : 아직 남아있는 직원들의 키의 합
	public static void powerset(int idx, int currentHeight, int remainHeight) {
		// 기저파트
		if (idx == N) {

			// 현재 점원 키의 합이 선반 높이 이상이면
			if (currentHeight >= B) {
				min = Math.min(min, currentHeight); // 둘 중 최솟값으로 저장
			}
			return;

		}
		// 재귀파트
		powerset(idx + 1, currentHeight + heights[idx], remainHeight - heights[idx]); // 현재 직원 추가해서 재귀호출
		powerset(idx + 1, currentHeight, remainHeight - heights[idx]); // 현재 직원 추가 안하고 재귀호출

	}
}