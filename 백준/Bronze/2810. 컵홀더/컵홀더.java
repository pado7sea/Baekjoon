import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 좌석의 수
		String str = br.readLine();

		int cup = 1; // 컵홀더 수

		for (int i = 0; i < N; i++) {
			if (str.charAt(i)=='S') {
				cup++;
			} else {
				cup++;
				i++;
			}
		}
		System.out.print(Math.min(cup,N));
	}
}