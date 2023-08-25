import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케수
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 오름차순 정렬해놓고
			Arrays.sort(arr);
			//두개씩 곱해가면서 그 결과가 단조증가하는 수인지 확인.찾으면 break.
			int max = -1; // 단조 증가하는 수 중에서 최댓값
			int danjo = -1; // 단조 증가하는 수
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int num = arr[i] * arr[j];
					// 단조 증가하는 수 인지 확인
					String strnum = Integer.toString(num);
					for (int k = 0; k < strnum.length() - 1; k++) {
						if (strnum.charAt(k) > strnum.charAt(k + 1)) {
							danjo = -1;
							break;
						} else {
							danjo = num;
						}
					}
					// 단조 증가하는 수 중에서 최댓값을 찾는다.
					if (danjo > max) {
						max = danjo;
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}