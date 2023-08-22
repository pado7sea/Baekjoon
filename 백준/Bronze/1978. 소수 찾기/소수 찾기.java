import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		int count = 0;
		int res = 0;

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			count = 0;
			for (int j = 2; j <= 1000; j++) {
				if (num[i] == j || num[i]==1 ) {
					continue;
				}
				if (num[i] % j == 0) {
					break;
				}
				count++;
			}
			if (count == 998) {
				res++;
			}
		}

		System.out.println(res);

	}
}