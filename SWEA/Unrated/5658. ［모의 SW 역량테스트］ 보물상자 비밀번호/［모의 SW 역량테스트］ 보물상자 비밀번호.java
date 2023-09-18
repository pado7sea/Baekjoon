import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());// 숫자의 개수 N
			int K = Integer.parseInt(st.nextToken());// 크기순서 K

			String box = br.readLine();
			Deque<String> deque = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				deque.add(box.charAt(i) + "");
			}

			HashSet<String> set = new HashSet<String>();

			// N/4회전 돌면 같은 값 나옴.1번만적게.. 돌리자
			for (int i = 0; i < N / 4; i++) {

				// N/4개씩 끊어서 set에 저장
				for (int j = 0; j < N; j+=(N/4)) {
					String key = "";
					for (int k = j; k < j + N / 4; k++) {
						String first = deque.remove();
						deque.add(first);
						key += first;
					}
					set.add(key);
				}

				// 데크의 마지막 값을 제일 앞에 넣자
				String last = deque.removeLast();
				deque.addFirst(last);
			}

			// set값을 리스트에 넣어서 내림차순정렬
			List<String> list = new ArrayList<>();
			Iterator<String> iter = set.iterator();

			while (iter.hasNext()) {
				list.add(iter.next());
			}
			Collections.sort(list, Collections.reverseOrder());
			int res = Integer.parseInt(list.get(K - 1), 16);
			System.out.println("#" + tc + " " + res);

		} // tc

	}// main
}