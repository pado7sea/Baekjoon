import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 응시자의 수
		int k = sc.nextInt(); // 상을 받는 사람의 수

		int[] score = new int[N]; // 각 학생의 점수
		for (int i = 0; i < N; i++) {
			score[i] = sc.nextInt();
		}

		selectionSort(score);

		System.out.print(score[N - k]);
	}

	public static int[] selectionSort(int[] arr) {
		int N = arr.length;
		for (int i = 0; i < N-1; i++) {
			int minIdx = i;
			for(int j = i+1; j < N; j++) {
				if(arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
		return arr;
	}
}
