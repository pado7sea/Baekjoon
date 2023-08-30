import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 지방의 수
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		// 각 지방의 예산 요청
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 총 예산
		int M = Integer.parseInt(br.readLine());

		int start = 0;
		// 최대 예산
		int end = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if (arr[i] > end) {
				end = arr[i];
			}
		}

		while (start <= end) {
			// 상한액
			int mid = (start + end) / 2;

			// 상한액을 넘지 않는 각 예산 요청액의 합
			int sum = 0;
			for (int i = 0; i < N; i++) {
				// 한 지방의 예산 요청액이 상한액보다 작으면 그대로 sum에 더하고
				if (mid >= arr[i]) {
					sum += arr[i];
					// 상한액보다 크면 상한액만큼을 sum에 더한다.
				} else if (mid < arr[i]) {
					sum += mid;
				}
			}
			// 예산 초과 나면 상한액을 줄이고 총 예산에 못미치면 상한액을 늘린다.
			if (sum > M) {
				end = mid - 1;
			} else if (sum <= M) {
				start = mid + 1;

			}
		} // while 이분탐색
		System.out.println(end);
	}// main
}