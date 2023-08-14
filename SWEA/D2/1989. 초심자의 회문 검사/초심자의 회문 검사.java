import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			String word = sc.next();
			String[] str = new String[word.length()];
			Stack<String> stack = new Stack<>();

			// 입력
			for (int i = 0; i < word.length(); i++) {
				// 배열과 스택에 동시저장
				str[i] = word.substring(i, i + 1); // 배열
				stack.push(str[i]); // 스택
			}

			// 스택에 있는 값을 pop해서 새로운 배열에 저장 (str2는 str을 뒤집은 배열)
			String[] str2 = new String[word.length()];

			for (int i = 0; i < word.length(); i++) {
				str2[i] = stack.pop();
			}

			// 출력
			// 문자열 배열을 문자열로 만드는 join메소드를 이용해서 문자열로 바꾼 뒤에, equals로 문자열 비교.
			if (String.join("", str).equals(String.join("", str2))) {
				System.out.println("#" + tc + " 1");
			} else {
				System.out.println("#" + tc + " 0");
			}
		}
	}
}
