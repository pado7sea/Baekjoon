import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 학생 수
		int K = sc.nextInt(); // 최대인원 수

		int room = 12; // 방의 수

		// 성별, 학년 입력
		int[][] student = new int[N][2];
		for (int i = 0; i < N; i++) {
			student[i][0] = sc.nextInt();
			student[i][1] = sc.nextInt();
		}

		// 성별로 나누고, 0~6 학년 별 카운팅
		int[] count0 = new int[7];
		int[] count1 = new int[7]; // 6+1
		for (int i = 0; i < N; i++) {
			if (student[i][0] == 0) {
				count0[student[i][1]]++;
			} else if (student[i][0] == 1) {
				count1[student[i][1]]++;
			}
		}

		int zeroRoom = 0;
		int plusRoom = 0;
		for (int i = 1; i < 7; i++) {
			// 카운트 배열에서 0인 요소의 개수
			if (count0[i] == 0)
				zeroRoom++;
			if (count1[i] == 0)
				zeroRoom++;

			// 최대 인원수 넘는 학년이 있을 때, 방을 분리해 주어야 함
			if (count0[i] > K) {
				plusRoom = (count0[i] / K) - 1; // 몫만큼 방의 개수 추가
				if (count0[i] % K != 0) { // 나머지가 있다면 방의 개수 1개 추가
					plusRoom++;
				}
			}
			if (count1[i] > K) {
				plusRoom = (count1[i] / K) - 1;
				if (count1[i] % K != 0) {
					plusRoom++;
				}
			}
		}

		System.out.println(room - zeroRoom + plusRoom);

	}
}