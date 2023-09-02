import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[][] arr;
	public static int countWhite;
	public static int countBlue;

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
		System.out.println(countWhite);
		System.out.println(countBlue);

	}// main

	// 색종이 4분할 하는 메소드(재귀)
	public static void cut(int size, int x, int y) {

		boolean check = true; // 색상을 확인하기 위한 변수
		
		//색종이의 시작점부터 사이즈만큼 순회
		out: for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {

				//색종이의 첫 좌표의 색과 다른 색이 등장하면 종료
				if (arr[x][y] != arr[i][j]) {
					check = false;
					break out;
				}
			}
		}

		// 전체 종이가 모두 같은 색으로 칠해져 있으면
		if (check) {
			if (arr[x][y] == 0) {
				countWhite++;// 모두 흰색으로 칠해져 있으면 흰색 색종이의 개수 증가+1
			} else {
				countBlue++;// 모두 파란색으로 칠해져 있으면 파란색 색종이의 개수 증가+1
			}

		} else {
			// 4분할
			int newSize = size / 2;
			cut(newSize, x, y);
			cut(newSize, x + newSize, y);
			cut(newSize, x, y + newSize);
			cut(newSize, x + newSize, y + newSize);
		}
	}
}