import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		System.out.println(comb(N, K));

	}

	public static int comb(int n, int k) {
		if (k == 0 || n == k) {
			return 1;
		}
		return comb(n - 1, k - 1) + comb(n - 1, k);
	}
}