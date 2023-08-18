import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String[] str = new String[N];
			Queue<String> queue = new LinkedList<>();

			// 입력
			for (int i = 0; i < N; i++) {
				str[i] = sc.next();
			}

			// 절반으로 나눴을 때, 나눈 덩어리에서 각각 첫 번째 인덱스를 큐에 추가.
			if (N % 2 == 1) {
				for (int i = 0; i < N / 2; i++) {
					queue.add(str[i]);
					queue.add(str[i + N / 2 + 1]);
				}
				queue.add(str[N / 2]);
			} else {
				for (int i = 0; i < N / 2; i++) {
					queue.add(str[i]);
					queue.add(str[i + N / 2]);
				}
			}

			// 출력
			System.out.print("#" + tc + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(queue.remove() + " ");
			}
			System.out.println();
		}
	}
}