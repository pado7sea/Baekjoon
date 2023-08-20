import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			char[][] grid = new char[N][N];

			// 입력
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					grid[i][j] = str.charAt(j); // String으로 입력받고 chatAt으로 한글자씩 쪼개서 배열에 저장
				}
			}

			int x = 0, y = 0; // 현재 위치
			int nx = 0, ny = 0; // 다음 위치

			// 4방탐색 : 왼쪽위, 왼쪽, 왼쪽아래, 아래
			int[] dx = { -1, 0, 1, 1 };
			int[] dy = { -1, -1, -1, 0 };

			int count = 0; // 돌의 개수를 세는 변수
			boolean omok = false; // 오목 유효 여부

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (grid[i][j] == 'o') { // 만약 'o'를 만나면
						x = i; // 현재 좌표를 저장
						y = j;
						// 4방탐색
						for (int d = 0; d < 4; d++) {
							count = 0; // 잊지말자..새로운 방향 탐색할 때마다 이전까지 만난 돌의 개수를 0으로 초기화!
							nx = x + dx[d]; // 다음 위치 탐색
							ny = y + dy[d];

							// 다음 위치가 배열 내에 존재하고 'o'를 만난다면
							while (nx >= 0 && nx < N && ny >= 0 && ny < N && grid[nx][ny] == 'o') {
								count++; // 돌의 개수 카운트

								nx = nx + dx[d]; // 같은 방향으로 계속 진행
								ny = ny + dy[d];

								if (count == 4) {
									omok = true;
									break;
								}

							}
						}
					}
				}
			}

			// 츌력
			if (omok) {
				System.out.println("#" + tc + " YES");
			} else {
				System.out.println("#" + tc + " NO");
			}

		}
	}
}
//오목은 방향을 계속 돌리면서 탐색하다가 조건 충족시 그 방향으로 쭉 가는 거고
//달팽이는 그 방향으로 가다가 조건 충족 안하면 방향을 바꾸는 거고!
