import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Stack<Integer> stack = new Stack<>();
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int res = 0; // 잘려진 쇠막대기 조각의 총 개수

			// 입력
			String str = sc.next();
			String[] strArr = new String[str.length()];
			for (int i = 0; i < str.length(); i++) {
				strArr[i] = str.substring(i, i + 1);
			}
			
			// 아이디어 : 쇠막대기 개수 + 레이저 왼쪽에 안 닫힌 괄호의 개수를 세면 레이저 하나가 쇠막대기 몇개를 자르는 지 알 수 있음

			// 쇠막대기 개수를 res에 저장하자.
			for(int i = 0; i <str.length();i++){
				if(strArr[i].equals("(")) { // ( 가 등장할 때마다 카운트하고
					res++;
				}
				if (strArr[i].equals("(")  && strArr[i + 1].equals(")")) { // 레이저 나올 때는 빼준다.
					res--;
				}
			}

			// 여는 괄호가 나올 때마다 스택에 삽입, 닫는 괄호가 나올 때마다 삭제.
			for (int i = 0; i < str.length(); i++) {
				// "()" 레이저가 나올 경우에는 그동안 스택에 저장되어있던 여는 괄호의 개수를 res에 저장한다.
				if (strArr[i].equals("(")  && strArr[i + 1].equals(")")) { 
					if(!stack.isEmpty())
						res += stack.size();
				}
				
				if (strArr[i].equals("(")) {
					stack.push(i);
				} else if (strArr[i].equals(")")) {
					stack.pop();
				}
			}
			
			
			System.out.println("#" + tc + " " + res);

		}
	}
}