import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 입력
			int N = 9;
			int ans = 1; // 아닐 경우 0으로 바꿈
			int[][] sudoku = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 검사시작
			// boolean배열을 만들어두고 1이 입력되면 boolean배열 1번 인덱스를 true로 바꿈.
			out: for (int i = 0; i < N; i++) {
				boolean[] row = new boolean[10]; // 행검사
				boolean[] col = new boolean[10]; // 열검사
				for (int j = 1; j < N; j++) {
					if (row[sudoku[i][j]] || col[sudoku[j][i]]) { // row배열이 이미 true라면 중복된 값이 존재한다는 뜻.
						ans = 0;
						break out;
					}
					// 해당숫자를 인덱스로 하는 boolean배열의 값을 true로 바꿔줌
					row[sudoku[i][j]] = true;
					col[sudoku[j][i]] = true;

					// 3X3검사. 각 박스의 시작점의 좌표는 0 3 6 셋 중에 하나임. 즉, 3으로 나눴을 때 나머지가 0인 숫자들임.
					if (i % 3 == 0 && j % 3 == 0) {
						boolean[] square = new boolean[10];
						for (int r = i; r < i + 3; r++) {
							for (int c = j; c < j + 3; c++) {
								if (square[sudoku[r][c]]) {
									ans = 0;
									break out;
								}
								square[sudoku[r][c]] = true;
							}
						}
					}

				}
			}
			System.out.println("#"+tc+" "+ans);
		} // tc
	}// main
}