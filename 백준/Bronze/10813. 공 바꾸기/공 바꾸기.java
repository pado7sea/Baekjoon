import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] basket = new int[N + 1];
		for (int x = 1; x < N + 1; x++) {
			basket[x] = x;
		}

		for (int t = 1; t <= M; t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			int temp = basket[i];
			basket[i] = basket[j];
			basket[j] = temp;

		}
		for (int x = 1; x < N + 1; x++) {
			System.out.print(basket[x] + " ");
		}
	}
}