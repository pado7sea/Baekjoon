import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		String str = String.valueOf(A * B * C);
		int[] intArr = new int[10];

		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < 10; j++) {
				if (Integer.parseInt(str.charAt(i) + "") == j) {
					intArr[j] += 1;
				}
			}
		}
		for (int i : intArr) {
			System.out.println(i);
		}

	}
}