import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int j = 0; j < T; j++) {

			int N = 1000;
			int num = sc.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

//			// 제일 큰 수
//			int K = -1;
//			for (int i = 0; i < N; i++) {
//				if (arr[i] > K)
//					K = arr[i];
//			}

			// 카운팅
			int[] count = new int[101];
			for (int i = 0; i < N; i++) {
				count[arr[i]]++;
			}

			// 순회하면서 젤 큰 인덱스 찾아내라~
			int mode = -1;
			int res = -1;
			for (int i = 0; i < count.length; i++) {
				if (count[i] >= mode) {
					mode = count[i];
					res = i;
				}

			}

			System.out.println("#" + num + " " + res);
		}

	}
}
