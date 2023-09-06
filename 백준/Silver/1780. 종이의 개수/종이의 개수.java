import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[][] arr; // 색종이 배열
	public static int minusone; // -1 종이 개수
	public static int zero; // 0 종이 개수
	public static int plusone; // 1 종이 개수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 배열의 크기 N을 입력받음
		int N = Integer.parseInt(br.readLine());

		// N개의 정수를 입력받아 배열 arr에 저장
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cut(N, 0, 0);

		// 출력
		System.out.println(minusone);
		System.out.println(zero);
		System.out.println(plusone);

	}// main

	// 색종이 4분할 하는 메소드(재귀), size는 색종이 사이즈. x, y는 색종이 시작점 좌표
	public static void cut(int size, int x, int y) {

		boolean check = true; // 색상을 확인하기 위한 변수

		// 색종이의 시작점부터 사이즈만큼 순회
		out: for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {

				// 색종이의 시작점 좌표의 색과 다른 색이 등장하면 종료
				if (arr[x][y] != arr[i][j]) {
					check = false;
					break out;
				}
			}
		}

		// 전체 종이가 모두 같은 색으로 칠해져 있으면
		if (check) {
			if (arr[x][y] == -1) {
				minusone++; // 시작점 좌표가 -1이면 -1 종이의 개수 증가+1
			} else if (arr[x][y] == 0) {
				zero++;	// 시작점 좌표가 0이면 0 종이의 개수 증가+1
			} else if (arr[x][y] == 1) {
				plusone++;	// 시작점 좌표가 1이면  1 종이의 개수 증가+1
			}

		} else {
			// 9분할
			int newSize = size / 3;

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					cut(newSize, x + i * newSize, y + j * newSize);
				}
			}
		}
	}
}