import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		int[] dx = { 0, 1, 0, -1 };	// 델타 : 우 하 좌 상
		int[] dy = { 1, 0, -1, 0 };

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	// 달팽이 배열의 크기
			
			int n = 1;			// 달팽이의 숫자 시작은 1부터 빙글빙글 증가할 것임
			int d = 0;			// 우/하/좌/상 어느 방향으로 증가할 것인지 진행방향을 정해주는 델타 내의 인덱스 
			
			int x = 0, y = 0;	// 현재 위치
			int nx, ny;			// 다음 위치(임시)
			
			int[][] arr = new int[N][N]; // 달팽이 N*N 배열

			while (n <= N * N) {

				arr[x][y] = n++;	// 현재 위치에 n을 입력하고 그 다음에는 n+1;
				nx = x + dx[d];		// 다음 위치(임시) 
				ny = y + dy[d];

				// 만약, 다음 위치가 N*N 배열 밖이거나 이미 달팽이숫자가 채워진 행이나 열을 만난다면 
				// 델타 내의 인덱스인 d에 +1을 하여 진행 방향을 바꿔준다. 
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] != 0) {
					d = (d + 1) % 4;  // 계속 델타(원소가 4개) 내에서 순회할 수 있도록 나머지(%4)를 사용해준다.
				}

				x += dx[d];	// 다음 위치(확정)이 현재 위치가 된다.
				y += dy[d];
			}

			// 출력
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}