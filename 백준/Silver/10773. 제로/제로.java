import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();

		int sum = 0;
		
		for (int i = 0; i < K; i++) {
			stack.push(sc.nextInt());
			if (stack.peek() == 0) {
				stack.pop();
				stack.pop();
			}
		}

		while(!stack.empty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
		
		sc.close();
	}
}