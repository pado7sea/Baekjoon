import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();

		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {

			String str = sc.next();
			for (int i = 0; i < str.length(); i++) {

				char ch = str.charAt(i);
				if (ch == '(') {
					stack.push(ch);
				} else if (ch == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						stack.push(ch);
					}
				}
			}
			
			if (stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			stack.clear();
		}

	}
}