/* 아이디어 : 행 한줄 단위로 순회 돌려서 어느 열에 퀸 놓을지 정하고, 
다음 행으로 넘어가서 순회 돌려서 어느 열에 퀸 놓을지 정하고 ~ 이렇게 할 거임!! */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[][] board;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 체스판의 크기를 저장

		board = new int[N][N]; // 크기가 N x N인 체스판
		count = 0; // 퀸을 놓는 방법의 수
		nqueen(0); // 퀸을 놓는 방법을 구하는 메소드

		System.out.println(count); // 퀸을 놓는 방법의 수 출력
	}

	// 퀸을 놓는 방법을 구하는 메소드
	private static void nqueen(int row) {
		// 기저파트 : 행마다 퀸을 하나씩 놓았다면 종료
		if (row == N) {
			count++;
			return;
		}

		// 재귀 파트
		for (int col = 0; col < N; col++) {
			// col행 row열에 퀸을 놓을 수 있는지 검사
			if (findPosition(row, col)) {
				board[row][col] = 1; // 퀸을 놓는다
				nqueen(row + 1); // 다음 행으로 이동
				board[row][col] = 0; // 퀸을 제거하여 다른 경우를 탐색
			}
		}

	}

	// 같은 열, 대각선에 다른 퀸이 있는지 검사하는 메소드
	private static boolean findPosition(int row, int col) {
		// 같은 열에 다른 퀸이 있는지 검사
		for (int i = 0; i < row; i++) {
			if (board[i][col] == 1) { // 같은 열이니까 col고정
				return false;
			}
		}

		// 행 단위로 쭉쭉 내려가니까 퀸 놓을 자리를 정하면, 왼쪽 위 대각선이랑 오른쪽 위 대각선을 검사해야 함!(즉, 윗부분을 검사한다고 생각하면 됨)
		// 왼쪽 위 대각선
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		// 오른쪽 위 대각선
		for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		return true;
	}
}