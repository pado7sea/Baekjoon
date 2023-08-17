import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			Stack<Character> stack = new Stack<>();
			boolean check = true; // 균형을 이루는지 체크하는 변수

			String str = sc.nextLine();

			if (str.equals(".")) { // 맨 마지막에 온점 하나(".")가 들어오면 입력 종료.
				break;
			}
			
			for (int i = 0; i < str.length(); i++) {

				char ch = str.charAt(i);
				// 여는 괄호일 때, push
				if (ch == '(' || ch == '[') {
					stack.push(ch);

					// 닫는 소괄호일 때
				} else if (ch == ')') {
					// 스택이 비어있지 않고 짝이 맞는다면
					if (!stack.isEmpty() && stack.pop() == '(') {
						check = true;
					} else {
						check = false;
						break;
					}

					// 닫는 대괄호일 때
				} else if (ch == ']') {
					// 스택이 비어있지 않고 짝이 맞는다면
					if (!stack.isEmpty() && stack.pop() == '[') {
						check = true;
					} else {
						check = false;
						break;
					}
				}
			}

			// 스택에 남은 여는 괄호가 있으면 x
			if (!stack.isEmpty()) {
				check = false;
			}

			// 출력
			if (check) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

		}
	}
}
