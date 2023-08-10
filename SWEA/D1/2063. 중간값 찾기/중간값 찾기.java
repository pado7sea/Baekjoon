import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] intArr = new int[N];

		for (int i = 0; i < N; i++) {
			intArr[i] = sc.nextInt();
		}

		int[] resArr = countingSort(intArr);

		System.out.print(resArr[(N - 1) / 2]);

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
