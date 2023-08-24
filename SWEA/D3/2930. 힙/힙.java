import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
		for (int tc = 1; tc <= T; tc++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			int N = Integer.parseInt(br.readLine()); // 수행해야하는 연산의 수

			sb.append("#" + tc);
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int operation = Integer.parseInt(st.nextToken());

				// 연산 1
				if (operation == 1) {
					int x = Integer.parseInt(st.nextToken()); // x를 최대 힙에 추가해야 한다.
					pq.add(-x);
					// 연산2
				} else {
					if (pq.size() == 0) {
						sb.append(" -1");
					} else {
						sb.append(" " + -pq.poll());
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}