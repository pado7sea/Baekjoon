import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0) {
				break;
			}

			if (a < b && b % a == 0) {
				System.out.println("factor");
			} else if (a > b && a % b == 0) {
				System.out.println("multiple");
			} else {
				System.out.println("neither");
			}
		}
	}
}