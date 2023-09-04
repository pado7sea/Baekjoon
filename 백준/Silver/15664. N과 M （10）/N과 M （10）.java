import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int number[];
	static int select[];
	static boolean check[];
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
		check = new boolean[N];
		backtracking(0, 0);

		System.out.println(sb);
	}

	public static void backtracking(int idx, int start) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(select[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// 중복을 방지하기 위해 사용한 숫자를 체크
	    boolean[] used = new boolean[10001]; // 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수
	    
		for (int i = start; i < N; i++) {
			if (!check[i] && !used[number[i]]) {
				select[idx] = number[i];

				check[i] = true;
				used[number[i]] = true; // 숫자를 사용했음을 체크

				backtracking(idx + 1, i);
				check[i] = false;
			}
		}
	}
}