import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		// 입력
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();

		// 큐에 1~N 저장
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		sb.append('<');
		while (queue.size() > 1) {
			// 맨앞에서 뽑아내서 뒤로 다시 집어넣는 과정을 k-1번 반복
			// 그리고 그 다음에 한사람 제거
			for (int i = 1; i <= K - 1; i++) {
				int temp = queue.poll();
				queue.offer(temp);
			}
			sb.append(queue.poll()).append(", ");
		}

		sb.append(queue.poll()).append('>');
		System.out.println(sb);

	}
}