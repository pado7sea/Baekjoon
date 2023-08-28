import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int ans = 0;

		if (A != B && A != C && B != C) {
			int[] arr = { A, B, C };
			Arrays.sort(arr);
			ans = arr[2] * 100;
		} else {
			if (A == B && B == C) {
				ans = 10000 + A * 1000;

			} else {
				if (A == B) {
					ans = 1000 + A * 100;
				} else if (B == C) {
					ans = 1000 + B * 100;
				} else if (C == A) {
					ans = 1000 + C * 100;
				}
			}
		}
		System.out.println(ans);
	}
}