import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		for(int i = ch.length-1; i>=0;i--) {
			System.out.print(ch[i]);
		}
	}
}