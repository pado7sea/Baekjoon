import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			int resH, resW;

			if (N % H == 0) {
				resH = H;
				resW = N / H;
			} else {
				resH = N % H;
				resW = (N / H) + 1;
			}

			System.out.println(resH * 100 + resW);
		}
	}
}