import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 델타 : 하, 우, 상, 좌
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int N = Integer.parseInt(br.readLine()); // 달팽이 배열 크기
		int findXY = Integer.parseInt(br.readLine()); // 입력 받은 자연수의 좌표는?

		int findX = 0, findY = 0; // 찾고 싶은 좌표

		int n = N * N; // 달팽이 시작 넘버
		int[][] snail = new int[N][N]; // 달팽이 배열

		int x = 0, y = 0; // 현재위치
		int nx, ny; // 임시위치

		int d = 0; // 델타의 인덱스(진행방향을 나타냄)
		
		// 달팽이 배열
		while (n >= 1) { // 마지막 숫자인 1보다 작아질 때까지 while문 실행
			snail[x][y] = n--;

			nx = x + dr[d];
			ny = y + dc[d];

			if (nx >= N || nx < 0 || ny >= N || ny < 0 || snail[nx][ny] != 0) {
				d = (d + 1) % 4; // 배열 밖이거나 배열의 값이 0이 아니라면 방향전환
			}

			x += dr[d]; // 바뀐 진행방향으로 1만큼 위치를 증가한다.
			y += dc[d];
		}
		
		// 시간초과 방지
        StringBuilder sb = new StringBuilder();

		// 달팽이 배열 출력
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sb.append(snail[r][c] + " ");
				if (snail[r][c] == findXY) {
					findX = r + 1;
					findY = c + 1;
				}
			}
			sb.append("\n");
		}

		// 좌표 출력
		sb.append(findX + " " + findY);
		System.out.println(sb);
	}
}