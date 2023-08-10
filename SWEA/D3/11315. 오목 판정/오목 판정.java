import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {

			// 입력
			int N = sc.nextInt();
			char[][] str = new char[N][N];

			for (int r = 0; r < N; r++) {
				String strarr = sc.next();
				str[r] = strarr.toCharArray();
			}

			// 돌이 다섯 개 이상 연속한 곳이 있으면 yes = 1;
			int yes = 0;

			// 행
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (str[r][c] == 'o') { // 행에서 o을 발견했으면 그 다음 확인할 수 있는 공간이 4개가 남았는지 확인부터 먼저 함.
						if (N - c >= 5) {
							if (str[r][c + 1] == 'o' && str[r][c + 2] == 'o' && str[r][c + 3] == 'o'
									&& str[r][c + 4] == 'o') {
								yes = 1;
							}
						}
					}
				}
			}

			// 열
			for (int c = 0; c < N; c++) {
				for (int r = 0; r < N; r++) {
					if (str[r][c] == 'o') { // 열에서 o을 발견했으면 그 다음 확인할 수 있는 공간이 4개가 남았는지 확인부터 먼저 함.
						if (N - r >= 5) {
							if (str[r + 1][c] == 'o' && str[r + 2][c] == 'o' && str[r + 3][c] == 'o'
									&& str[r + 4][c] == 'o') {
								yes = 1;
							}
						}
					}
				}
			}

			// 대각선
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					if (str[r][c] == 'o') { // 왼쪽 위에서 오른쪽 아래로 내려가는 대각선
						if (N - r >= 5 && N - c >= 5) { 
							if (str[r + 1][c + 1] == 'o' && str[r + 2][c + 2] == 'o' && str[r + 3][c + 3] == 'o'
									&& str[r + 4][c + 4] == 'o') {
								yes = 1;
							}
						}
					}

					if (str[r][c] == 'o') { // 오른쪽 위에서 왼쪽 아래로 내려가는 대각선
						if (N - r >= 5 && c >= 4) {
							if (str[r + 1][c - 1] == 'o' && str[r + 2][c - 2] == 'o' && str[r + 3][c - 3] == 'o'
									&& str[r + 4][c - 4] == 'o') {
								yes = 1;
							}
						}
					}

				}
			}

			if (yes == 1) {
				System.out.println("#" + testcase + " YES");
			} else {
				System.out.println("#" + testcase + " NO");
			}

		}
	}
}