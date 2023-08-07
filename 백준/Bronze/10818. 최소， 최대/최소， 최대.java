import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		int N = sc.nextInt();
		int[] intArr = new int[N];
		
		for (int i = 0; i < N; i++) {
			intArr[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			if (intArr[i] > max) {
				max = intArr[i];
			}
			if (intArr[i] < min) {
				min = intArr[i];
			}
		}
		System.out.print(min+" "+max);
	}
}