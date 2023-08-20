import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// 델타 : 우 하 좌 상
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		int M = sc.nextInt(); // 달팽이 배열 크기
		int N = sc.nextInt(); // 달팽이 배열 크기
		int n = M * N; // 달팽이 시작 넘버
		int[][] snail = new int[M][N]; // 달팽이 배열

		int x = 0, y = 0; // 현재위치
		int nx, ny; // 임시위치

		int d = 0; // 델타의 인덱스(진행방향을 나타냄)
		int count = 0; // 선을 꺾을 때마다 증가

		// 달팽이 배열
		while (n >= 1) { // 마지막 숫자인 1보다 작아질 때까지 while문 실행
			snail[x][y] = n--;

			nx = x + dr[d];
			ny = y + dc[d];

			if (nx >= M || nx < 0 || ny >= N || ny < 0 || snail[nx][ny] != 0) {
				d = (d + 1) % 4; // 배열 밖이거나 배열의 값이 0이 아니라면 방향전환
				count++;
			}

			x += dr[d]; // 바뀐 진행방향으로 1만큼 위치를 증가한다.
			y += dc[d];
		}
		System.out.println(count-1);
	}
}
