import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int testcase = 1; testcase <= 10; testcase++) {
			int t = sc.nextInt();

			// 입력
			int[][] grid = new int[100][100];
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					grid[r][c] = sc.nextInt();
				}
			}

			// 각 행의 합
			int[] sum = new int[100];
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					sum[r] += grid[r][c];
				}
			}

			int max = -1;
			for (int i = 0; i < 100; i++) {
				if (sum[i] > max) {
					max = sum[i];
				}
			}

			// 각 열의 합
			int[] sum2 = new int[100];
			for (int c = 0; c < 100; c++) {
				for (int r = 0; r < 100; r++) {
					sum2[c] += grid[r][c];
				}
			}

			for (int i = 0; i < 100; i++) {
				if (sum2[i] > max) {
					max = sum2[i];
				}
			}

			// 각 대각선의 합
			int[] sum3 = new int[100];
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					if (r == c) {
						sum3[r] += grid[r][c];
					}
					if ((r + c) == 100) {
						sum3[r] += grid[r][c];
					}
				}
			}

			for (int i = 0; i < 100; i++) {
				if (sum3[i] > max) {
					max = sum3[i];
				}
			}

			System.out.println("#" + testcase + " " + max);
		}
	}
}
