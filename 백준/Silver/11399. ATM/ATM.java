import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());// 사람의 수
		int[] time = new int[N];
		int res = 0; 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순으로 정렬
		Arrays.sort(time);
		// 0번은 N번 더해지고 1번은 N-1번 더해지고...
		for (int i = 0, k = 0; i < N; i++, k++) {
			res += (time[i] * (N - k));
		}
		System.out.println(res);
	}
}