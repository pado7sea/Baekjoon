import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cook = Integer.parseInt(br.readLine());

		int ansH = (h + (m + cook) / 60) % 24;
		int ansM = (m + cook) % 60;

		System.out.print(ansH + " " + ansM);
	}
}