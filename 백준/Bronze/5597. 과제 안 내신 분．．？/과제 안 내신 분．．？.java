import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[31];
		for (int tc = 1; tc <= 28; tc++) {
			num[sc.nextInt()]++;
		}

		for (int i = 1; i <= 30; i++) {
			if (num[i] == 0)
				System.out.println(i);
		}

	}
}