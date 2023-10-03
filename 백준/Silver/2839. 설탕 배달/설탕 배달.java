import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		// 2차 방정식. 봉지의 개수가 최소이려면 식을 만족하는 i,j조합 중에서 j가 더 큰 조합을 골라야 한다..
		for (int i = 0; i <= N / 3; i++) {
			for (int j = 0; j <= N / 5; j++) {
				if (5 * j + 3 * i == N) { 
					System.out.println(i + j);
					return;
				}
			}
		}
		System.out.println(-1);
	}

}
