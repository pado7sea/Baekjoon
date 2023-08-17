import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;
		int sum = 0; //누적합
		int sumBefore = 0; //직전 누적합
		for (int i = 1; i <= T; i++) {
			
			int n = sc.nextInt();
			sum += n;
			
			if (sum > 100) {
				sumBefore = sum - n; //현재값을 더하기 직전 sum 값
				break;
			}

		}
		
		if (100 - sumBefore < sum - 100) {
			System.out.println(sumBefore);
		} else {
			System.out.println(sum);
		}
	}
}