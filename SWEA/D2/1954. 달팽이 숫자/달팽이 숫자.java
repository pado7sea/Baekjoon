import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();

			int[][] snail = new int[N][N];

			// 시작은 1부터~
			int num = 1;

			// 델타 : 우 하 좌 상
			int[][] drc = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
			int d = 0;

			// 현재 나의 좌표
			int nr = 0;
			int nc = 0;

			while (num <= N * N) {

				snail[nr][nc] = num;
				num++;
				
				//임시로 다음으로 한 칸 옮겨서 범위내인지(범위가 아니면 꺾어야함), 0인지 확인(0이 아니면 꺾어야 함)
				int tempnr = nr + drc[d][0];
				int tempnc = nc + drc[d][1];
				if (isRange2(tempnr, tempnc, N) && snail[tempnr][tempnc] == 0) {
					nr = tempnr;
					nc = tempnc;

					//꺾어야 하면 d에 1을 추가해서 진행 방향을 바꿔준다.
				} else {
					d = (d + 1) % 4;
					nr = nr + drc[d][0];
					nc = nc + drc[d][1];
				}

			}

			// 출력^^
			System.out.println("#" + testcase);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	// 범위 내에 있으면 true 반환하는 함수
	public static boolean isRange2(int nr, int nc, int N) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		return false;
	}
}
