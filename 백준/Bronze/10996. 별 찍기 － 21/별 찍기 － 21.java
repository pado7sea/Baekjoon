import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int N1 = 0;
		int N2 = 0;
		for (int j = 0; j < N; j++) {
			
			if (N % 2 == 0) {
				N1 = N / 2;
				N2 = N / 2;
			} else if (N % 2 == 1) {
				N1 = (N + 1) / 2;
				N2 = (N - 1) / 2;
			}
			for (int i = 0; i < N1; i++) {
				System.out.print("* ");
			}
			System.out.println();

			for (int i = 0; i < N2; i++) {
				System.out.print(" *");
			}
			System.out.println();

		}

	}
}
