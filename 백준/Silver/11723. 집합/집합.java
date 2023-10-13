import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer> list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		list = new ArrayList<>();

		int N = Integer.parseInt(br.readLine()); // 연산의 수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String str = st.nextToken();

			if (str.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				add(x);
			} else if (str.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				remove(x);
			} else if (str.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				check(x);
			} else if (str.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				toggle(x);
			} else if (str.equals("all")) {
				list.clear();
				for (int j = 1; j <= 20; j++) {
					list.add(j);
				}
			} else if (str.equals("empty")) {
				list.clear();
			}
		}
		System.out.println(sb);

	}

	public static void add(int x) {
		list.add(x);
	}

	public static void remove(int x) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == x)
				list.remove(i);
		}
	}

	public static void check(int x) {
		boolean flag = true;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == x) {
				flag = false;
				break;
			}
		}
		if (flag) {
			sb.append(0).append("\n");
			return;
		}
		sb.append(1).append("\n");
	}

	public static void toggle(int x) {
		boolean flag = true;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == x) {
				list.remove(i);
				flag = false;
			}
		}
		if (flag) {
			list.add(x);
		}
	}

}