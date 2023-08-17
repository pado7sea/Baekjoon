import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {

			int N = sc.nextInt();
			String M = sc.next();


			List<Character> operator = Arrays.asList('+', '-', '*', '/', '(', ')'); // 연산자 리스트

			// 중위 -> 후위 표기
			Stack<Character> stack = new Stack<>();
			String back = ""; 
			for (int i = 0; i < N; i++) {
				char ch = M.charAt(i);
				
				if (!operator.contains(ch)) {	// 피연산자일 때, 출력
					back += ch;
				} else {	//연산자일 때 
					if(stack.isEmpty()) {	// + 연산자일 때, 스택이 공백상태라면 그냥 넣는다.
						stack.push(ch);
					} else {	// + 연산자일 때 비어있지 않다면 (스택에 있는 것도 + 연산자 일테니) pop한다.
						back += stack.pop();
						stack.push(ch);
					}
				}
			}
			while(!stack.isEmpty()) { // 다읽고 끝났는데 스택이 공백이 아니라면 공백이 될때까지 pop하면서 출력 
                back += stack.pop();
            }

			// 후위 표기 -> 계산
			Stack<Integer> stack2 = new Stack<>();
			for (int i = 0; i <N; i++) {
				char ch = back.charAt(i);
				if (!operator.contains(ch)) {	// 피연산자일 때, 스택에 넣는다.
					stack2.push((ch-'0')); 
				} else {	//연산자일 때, 필요한 피연산자의 개수만큼 꺼내어 계산하고 다시 넣는다. (순서 매우 중요)
					int b = stack2.pop();
					int a = stack2.pop();
					stack2.push(a+b);
					
				}
			}

			// 출력
			System.out.println("#" + tc + " " + stack2.pop());
		}
	}
}