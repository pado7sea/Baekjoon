import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt(); // 롤케잌 길이
		int N = sc.nextInt(); // 방청객 수

		int[] cake = new int[L + 1];
		int[][] person = new int[N+1][2]; // 방청객이 종이에 적어낸 수 저장하는 배열

		// 입력
		for (int i = 1; i <= N; i++) {
			person[i][0] = sc.nextInt(); // 시작 인덱스
			person[i][1] = sc.nextInt(); // 끝 인덱스
		}

		// 가장 많은 조각을 받을 것으로 기대하고 있던 방청객의 번호 구하기
		int max = -1;
		int happyPerson = N;
		for (int i = N; i >= 1; i--) {
			int range = person[i][1] - person[i][0];
			if (range >= max) {
				max = range;
				happyPerson = i;
			}
		}
		System.out.println(happyPerson);

		// 실제로 가장 많은 조각을 받은 방청객의 번호 구하기
		// 방청객 3->2->1 역순으로 롤케잌 배열에 값 입력
		for (int i = N; i >= 1; i--) {
			for (int j = person[i][0]; j <= person[i][1]; j++) {
				cake[j] = i;
			}
		}
		// 롤케잌 배열 내에서 0빼고 최빈수는?
		int[] count = new int[N + 1];
		for (int i = 1; i <= L; i++) {
			count[cake[i]]++;
		}
		int max2 = -1;
		int realHappyPerson = 1;
		for(int i = 1; i<count.length; i++) {
			if(count[i]>max2) {
				max2 = count[i];
				realHappyPerson = i;
			}
		}
		
		System.out.println(realHappyPerson);

	}
}
