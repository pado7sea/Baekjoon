import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 색종이의 수
		int[][] grid = new int[101][101];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); // 색종이를 붙인 위치
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 색종이 범위 만큼 카운트
			for (int j = a; j < a + 10; j++) {
				for (int k = b; k < b + 10; k++) {
					grid[j][k]++;
				}
			}
		}

		// 0세기
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (grid[i][j] != 0)
					count++;
			}
		}
		System.out.println(count);

	}
}