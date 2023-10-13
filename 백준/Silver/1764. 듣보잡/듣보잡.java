import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] strArr = new String[N];
		ArrayList<String> list = new ArrayList<>();

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				list.add(str);
			}
		}

		Collections.sort(list);

		sb.append(list.size()).append("\n");
		for (String x : list) {
			sb.append(x).append("\n");
		}
		System.out.println(sb);
	}
}