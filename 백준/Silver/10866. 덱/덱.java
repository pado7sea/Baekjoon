import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;



public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String nextWord = st.nextToken();
			

			switch (nextWord) {
			case "push_front":
				deque.addFirst(Integer.parseInt(st.nextToken())); // 맨 앞에 원소 삽입. 용량 초과 시 예외 발생
				break;

			case "push_back":
				deque.addLast(Integer.parseInt(st.nextToken())); // 마지막에 원소 삽입. 용량 초과 시 예외 발생
				break;

			case "pop_front":
				if (deque.isEmpty()) {
					System.out.println(-1);
					break;
				} else {
					System.out.println(deque.remove()); // 맨 앞의 원소 제거 후 해당 원소를 리턴. 덱이 비어있는 경우 예외 발생
					break;
				}

			case "pop_back":
				if (deque.isEmpty()) {
					System.out.println(-1);
					break;
				} else {
					System.out.println(deque.removeLast()); // 맨 뒤의 원소 제거 후 해당 원소를 리턴. 덱이 비어있는 경우 예외 발생
					break;
				}

			case "size":
				System.out.println(deque.size());
				break;

			case "empty":
				if (deque.isEmpty()) {
					System.out.println("1");
					break;

				} else {
					System.out.println("0");
					break;
				}

			case "front":
				if (deque.isEmpty()) {
					System.out.println(-1);
					break;

				} else {
					System.out.println(deque.peek()); // 맨 앞의 원소를 리턴. 덱이 비어있는 경우 null 리턴
					break;
				}

			case "back":
				if (deque.isEmpty()) {
					System.out.println(-1);
					break;
				} else {
					System.out.println(deque.peekLast()); // 맨 앞의 원소를 리턴. 덱이 비어있는 경우 null 리턴
					break;
				}

			default:
				break;
			}
		}



	}
}