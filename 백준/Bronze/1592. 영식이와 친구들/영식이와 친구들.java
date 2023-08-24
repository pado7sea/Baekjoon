import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 영식이와 친구들
		int M = Integer.parseInt(st.nextToken()); // 한 사람이 공을 M번 받았으면 게임은 끝
		int L = Integer.parseInt(st.nextToken()); // L번째 있는 사람에게 공을 던진다.

		int[] arr = new int[N + 1];
		int n = 1;
		int count = 0; // 공을 총 몇 번 던지는지
		arr[1] = 1;
		while (true) {

			if (arr[n] == M) {
				break;
			}
			
			// 공을 받은 횟수가 홀수이면 현재 위치에서 시계 방향으로 L번째 있는 사람
			// 공을 받은 횟수가 짝수이면 현재 위치에서 반시계 방향으로 L번째 있는 사람
			n = (arr[n] % 2 == 1) ? (n + L) : n - L;

			//배열의 범위 벗어났을 때(시계 방향)
			if (n > N)
				n %= N;

			//배열의 범위 벗어났을 때(반시계 방향)
			else if (n < 1)
				n += N;

			arr[n]++;
			count++;

		}
		System.out.println(count);

	}
}