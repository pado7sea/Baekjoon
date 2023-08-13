import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int count = 0; // 교환이 일어나는 횟수를 저장하는 변수
		int change1 = 0; // 교환이 일어났을 때 저장하는 변수
		int change2 = 0;

		// 입력
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for(int i = N-1; i >=1; i--) {
			int maxIdx = 0;
			for(int j = 1; j <= i; j++) {
				if(arr[maxIdx] < arr[j]) {
					maxIdx = j;
				}
			}
			if(i != maxIdx) {
				int temp = arr[i];
				arr[i] = arr[maxIdx];
				arr[maxIdx] = temp;
				count++;
				}
			if(count==K) {
				change1 = arr[maxIdx];
				change2 = arr[i];
				System.out.println(change1 + " " + change2);
				break;
			}
		}
		if(count<K) {
			System.out.println("-1");
		}
	}
}
