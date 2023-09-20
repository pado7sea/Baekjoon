import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {

			int n = sc.nextInt();

			int[] d = new int[11];

			d[1] = 1;
			d[2] = 2;
			d[3] = 4;

			for (int i = 4; i <= n; i++) {
				d[i] = d[i - 1] + d[i - 2] + d[i - 3];
			}
			System.out.println(d[n]);
		}
	}
}