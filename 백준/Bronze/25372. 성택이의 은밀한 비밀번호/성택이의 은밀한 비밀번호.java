import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			char[] charArr = br.readLine().toCharArray();
			int len = charArr.length;
			if(len >= 6 && len <= 9) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}
}