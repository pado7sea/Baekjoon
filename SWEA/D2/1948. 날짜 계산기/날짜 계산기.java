import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int month1 = sc.nextInt(); // 첫 번째 날짜의 월
			int day1 = sc.nextInt(); // 첫 번째 날짜의 일

			int month2 = sc.nextInt(); // 두 번째 날짜의 월
			int day2 = sc.nextInt(); // 두 번째 날짜의 일

			int res = 0; // 두 번째 날짜가 첫 번째 날짜의 며칠째인지

			// 배열에 각 월의 마지막 날짜를 저장해두고 두 번째 날짜의 월과 첫 번째의 날짜의 월의 차이를 계산한다.
			for (int i = month1; i < month2; i++) {
				res += month[i];
			}

			// 첫번째 날짜에서 이미 지난 일를 빼주고 두번째 날짜의 일을 더해준다. 며칠째인지 출력하는 문제이므로 +1을 해준다.
			res += +day2 - day1 + 1;

			System.out.println("#" + tc + " " + res);
		}

	}
}