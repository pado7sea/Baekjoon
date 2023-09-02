import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == -1)
				break;

			List<Integer> list = new ArrayList<>();
			int sum = 0;

			for (int i = 1; i < N; i++) {
				if (N % i == 0) {
					sum += i;
					list.add(i);
				}

			}

			if (sum == N) {
				System.out.print(N + " = ");
				for (int i = 0; i < list.size() - 1; i++) {
					System.out.print(list.get(i) + " + ");
				}
				System.out.println(list.get(list.size() - 1));
			} else {
				System.out.println(N + " is NOT perfect.");
			}
		}
	}
}