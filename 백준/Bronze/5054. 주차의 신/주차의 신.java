import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int testcase = 0; testcase < T; testcase++) {

			int n = sc.nextInt(); // 상점 수

			// 상점 수 입력
			int[] intArr = new int[n];
			for (int i = 0; i < n; i++) {
				intArr[i] = sc.nextInt();
			}

			Arrays.sort(intArr);

			int res = 2 * (intArr[intArr.length-1] - intArr[0]);
			System.out.println(res); // 왕복이라 x2

		}
	}
}