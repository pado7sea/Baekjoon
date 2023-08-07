import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = 0;

		if ((N % 4 == 0) & !(N % 100 == 0)) {
			res = 1;
		} else if (N % 400 == 0) {
			res = 1;
		} else {
			res = 0;
		}

		System.out.println(res);
	}
}