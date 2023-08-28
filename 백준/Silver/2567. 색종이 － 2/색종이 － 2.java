import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] grid = new int[101][101]; // 도화지

		int T = Integer.parseInt(br.readLine()); // 색종이의 수
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 색종이 범위만큼 1로 칠한다.
			for (int i = a; i < a + 10; i++) {
				for (int j = b; j < b + 10; j++) {
					grid[i][j] = 1;
				}
			}
		}

		int count = 0;

		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };

		// 순회하면서 1이 존재할 때 상하좌우로 탐색하여 0의 개수를 센다.(테두리면 둘레 카운트!)
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (grid[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						// 배열 내에 있고 0이면 테두리이므로 카운트를 증가시킨다.
						if (nx >= 1 && nx <= 100 && ny >= 1 && ny <= 100 && grid[nx][ny] == 0)
							count++;
						// 만약 1이 도화지의 끝선에 존재한다면 탐색하는 범위가 배열의 바깥이 될것이다. 이것도 역시 테두리다. 
						else if (nx < 1 || nx > 100 || ny < 1 || ny > 100)
							count++;
					}
				}
			}
		}
		System.out.println(count);

	}// main
}