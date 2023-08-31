import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int R = 6; // 6가지 수를 고른다.
	public static int[] lotto;
	public static int[] sel = new int[R];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			if (N == 0)
				break;
			
			lotto = new int[N];
			for (int i = 0; i < N; i++) {
				lotto[i] = Integer.parseInt(st.nextToken());
			}

			combination(0, 0);
			System.out.println();
		}//while
	}// main

	public static void combination(int idx, int sidx) {
		if (sidx == R) {
			for(int i = 0;i<R;i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		if (idx == N) {
			return;
		}
		sel[sidx] = lotto[idx];
		combination(idx + 1, sidx + 1);
		combination(idx + 1, sidx);

	}
}