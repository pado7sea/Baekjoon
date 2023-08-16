import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Stack<Integer> stack = new Stack<>();
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt();
			for (int i = 0; i < K; i++) {
				int input = sc.nextInt();
				if (input == 0) { // 입력이 0일 때
					if (!stack.isEmpty()) // 스택이 비어있지 않으면 pop
						stack.pop();
				} else { // 입력이 0이 아니라면 push
					stack.push(input);
				}
			}

			// 테스트 케이스마다 재민이가 받아 적은 수의 합
			int sum = 0;
			while (!stack.isEmpty()) { //stack이 완전히 빌 때까지 pop해서 sum에 더한다.
				sum += stack.pop();
			}

			System.out.println("#" + tc + " " + sum);

		}
	}
}
