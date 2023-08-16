import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			Stack<String> stack = new Stack<>();
			int check = 1; // 유효성 여부 ( 1:유효, 0:유효하지 않음 )

			// 입력
			int N = sc.nextInt(); // 테스트 케이스의 길이
			String str = sc.next();
			List<String> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(str.substring(i, i + 1));
			}

			List<String> open = Arrays.asList("(", "[", "{", "<");
			List<String> close = Arrays.asList(")", "]", "}", ">");

			for (int i = 0; i < N; i++) {
				if (open.contains(list.get(i))) { // 여는 괄호일 때 push
					stack.push(list.get(i));
				} else if (close.contains(list.get(i))) { // 닫는 괄호일 때 stack에서 pop한 값과 일치하는지 확인
					if (!stack.isEmpty()) {
						if (list.get(i).equals(close.get(0))) {
							if (stack.pop().equals(open.get(0))) {
								check = 1;
							} else {
								check = 0;
								break;
							}
						} else if (list.get(i).equals(close.get(1))) {
							if (stack.pop().equals(open.get(1))) {
								check = 1;
							} else {
								check = 0;
								break;
							}
						} else if (list.get(i).equals(close.get(2))) {
							if (stack.pop().equals(open.get(2))) {
								check = 1;
							} else {
								check = 0;
								break;
							}
						} else if (list.get(i).equals(close.get(3))) {
							if (stack.pop().equals(open.get(3))) {
								check = 1;
							} else {
								check = 0;
								break;
							}
						} else {
							check = 0;
							break;
						}
					}
				}
			}

			System.out.println("#" + tc + " " + check);

		}

	}
}
