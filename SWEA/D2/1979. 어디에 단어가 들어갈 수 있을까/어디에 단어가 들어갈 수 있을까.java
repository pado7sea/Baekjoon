import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {

			int N = sc.nextInt(); // 단어퍼즐 가로세로길이
			int K = sc.nextInt(); // 단어의 길이

			// 입력
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// i고정
			int count = 0; // 1이 나올 때마다 카운트
			int answer = 0; // 단어가 들어갈 수 있는 사이즈일 때마다 카운트

			for (int i = 0; i < N; i++) {
				count = 0;
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) { // 0이 나올 때까지 1의 개수를 count에 저장
						count++;
					} else {
						if (count == K) { // 1의 개수가 단어의 길이와 같아지면 answer +1
							answer++;
						}
						count = 0;
					}
					if (j == N - 1 && count == K) {
						answer++;
					}
						
				}
			}

			// j고정
			for (int j = 0; j < N; j++) {
				count = 0;
				for (int i = 0; i < N; i++) {
					if (arr[i][j] == 1) {
						count++;
					} else {
						if (count == K) {
							answer++;

						}
						count = 0;
					}
					if (i == N - 1 && count == K) {
						answer++;
					}
						
				}
			}
			System.out.println("#" + (t + 1) + " " + answer);
			answer = 0;
		}
	}
}
