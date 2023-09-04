import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int number[];
	static int select[];
//	static boolean check[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		number = new int[N];
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(number);

		select = new int[M];
//		check = new boolean[N];
		backtracking(0);

		System.out.println(sb);
	}

	public static void backtracking(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(select[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
//			if (!check[i]) {
				select[idx] = number[i];

//				check[i] = true;
				backtracking(idx + 1);
//				check[i] = false;
//			}
		}
	}
}