import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();

		while (true) {

			String str = sc.next();

			if (str.equals("0")) {
				return;
			}
			
			for (int i = 0; i < str.length(); i++) {
				stack.push(str.charAt(i));
			}

			String str2 = "";
			for (int i = 0; i < str.length(); i++) {
				str2 += stack.pop();
			}

			if (str.equals(str2)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

		}

	}
}