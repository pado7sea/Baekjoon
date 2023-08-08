import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// -1 배열
		int[] intArr = new int[26];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = -1;
		}

		// 입력
		String str = sc.next();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (intArr[c - 'a'] == -1)
				intArr[c - 'a'] = i;
		}
		for (int x : intArr) {
			System.out.print(x+" ");
		}

	}
}