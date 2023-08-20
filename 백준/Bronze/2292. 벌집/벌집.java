import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int lastNum = 1; // 각 라인의 마지막 번호
		int i = 0; // N까지 가기 위한 최소 방의 개수
		while (N != 1) { //입력값이 1이면 0이 나오지 않도록 해야함.
			lastNum += 6 * i; // 방 개수는 6개씩 늘어남.
			i++;
			if (N <= lastNum) {
				System.out.println(i);
				return; // N이 각 라인의 마지막 번호보다 커지면 종료
			}
		}
		System.out.println(1);
	}
}