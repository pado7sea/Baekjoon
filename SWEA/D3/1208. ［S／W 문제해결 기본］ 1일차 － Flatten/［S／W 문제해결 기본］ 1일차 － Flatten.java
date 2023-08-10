import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int j = 0; j < 10; j++) {

			int T = sc.nextInt(); // 덤프 횟수
			int B = 100; // 가로길이

			int[] arr = new int[B+1];
			for (int i = 1; i < B+1; i++) {
				arr[i] = sc.nextInt();
			}

			// 덤프 횟수만큼 포문 반복.
			for (int i = 0; i < T; i++) {
				// 오름차순 정렬
				arr = countingSort(arr);
				// 덤프.
				arr[1]++;
				arr[B]--;
			}

			// 오름차순
			arr = countingSort(arr);
			// 최고점과 최저점의 높이 차 = 젤 뒤의 값 - 젤 앞의 값
			int res = arr[B] - arr[1];

			System.out.println("#" + (j + 1) + " " + res);
		}

	}

	public static int[] countingSort(int[] intArr) {

		int L = intArr.length;

		// 1. 데이터 중 가장 큰 값
		int K = -1;
		for (int i = 0; i < L; i++) {
			if (intArr[i] > K) {
				K = intArr[i];
			}
		}

		// 2. 개수 카운팅
		int[] count = new int[L];
		for (int i = 0; i < L; i++) {
			count[intArr[i]]++;
		}

		// 3. 누적합
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		// 4. 값 바꾸기
		int[] sortArr = new int[L];
		for (int i = L - 1; i >= 0; i--) {
			sortArr[--count[intArr[i]]] = intArr[i]; // count배열의 값은 intArr[i] 이 들어갈 시작점 -1임
		}

		return sortArr;
	}
}
