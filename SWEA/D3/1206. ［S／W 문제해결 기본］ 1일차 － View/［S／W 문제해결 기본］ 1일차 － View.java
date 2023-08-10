import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {

			int N = sc.nextInt();
			int[] intArr = new int[N];
			int count = 0;

			// 건물 높이 입력
			for (int j = 0; j < N; j++) {
				intArr[j] = sc.nextInt();
			}

			for (int j = 2; j < N - 2; j++) { // 맨 왼쪽 두 칸과 맨 오른쪽 두 칸에는 건물이 지어지지 않는다.
				// 젤 첫건물 젤 높은층 A, 거리 2만큼 앞뒤로 탐색
				int a = 0;
				while ((intArr[j] - a) > 0) {
					// A보다 작은 수만 존재하면 count++하고 A-1 탐색 (처음 반복)
					if ((intArr[j] - a > intArr[j - 2]) && (intArr[j] - a > intArr[j - 1])
							&& (intArr[j] - a > intArr[j + 1]) && (intArr[j] - a > intArr[j + 2])) {
						count++;
						a++;

						// A보다 큰 수가 존재하면 탐색 중지 하고 옆건물 제일높은층(B)로 넘어간다. (처음 반복)
					} else {
						break;
					}
				}
			}
			System.out.println("#" + (i + 1) + " " + count);
		}
	}
}
