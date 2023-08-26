import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		String str = br.readLine();
		String str2 = "";
		for (int i = 0; i < str.length(); i++) {
			stack.add(str.charAt(i));
		}
		for (int i = 0; i < str.length(); i++) {
			str2 += stack.pop();
		}

		if (str.equals(str2)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}