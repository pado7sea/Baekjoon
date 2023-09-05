import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 배열의 크기 입력
		int N = Integer.parseInt(br.readLine());
		// 배열을 별로 채움
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = '*';
			}
		}

		// blank 함수를 호출하여 별 패턴 중앙 부분을 공백으로 바꿈
		blank(N, 0, 0);

		// 별 패턴 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}// main

	public static void blank(int N, int x, int y) {
		// 기저 파트
		if (N == 1) {
			return;
		}

		// 가운데를 공백으로 만듦
		int div = N / 3;
		for (int i = x + div; i < x + 2 * div; i++) {
			for (int j = y + div; j < y + 2 * div; j++) {
				arr[i][j] = ' ';
			}
		}

		// 재귀 파트 : blank 함수를 재귀 호출하여 패턴을 계속 만듦
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue; // 중앙 부분은 처리하지 않음
                }
                blank(div, x + i * div, y + j * div);
            }
        }
//		blank(N / 3, x, y);
//		blank(N / 3, x, y + N / 3);
//		blank(N / 3, x, y + (N / 3) * 2);
//		blank(N / 3, x + N / 3, y);
//		blank(N / 3, x + N / 3, y + (N / 3) * 2);
//		blank(N / 3, x + (N / 3) * 2, y);
//		blank(N / 3, x + (N / 3) * 2, y + N / 3);
//		blank(N / 3, x + (N / 3) * 2, y + (N / 3) * 2);

	}
}