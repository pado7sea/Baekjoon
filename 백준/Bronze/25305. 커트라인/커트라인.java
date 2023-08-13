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
        
		int[] res = new int[N];
		res = countingSort(score);

		System.out.print(res[N - k]);
	}

	public static int[] countingSort(int[] arr) {
		int N = arr.length;
		int[] count = new int[10001];
		for (int i = 0; i < N; i++) {
			count[arr[i]]++;
		}
		for (int i = 0; i < count.length-1; i++) {
			count[i+1] += count[i];
		}
		int[] sortArr = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			sortArr[--count[arr[i]]] = arr[i];
		}

		return sortArr;

	}
}
