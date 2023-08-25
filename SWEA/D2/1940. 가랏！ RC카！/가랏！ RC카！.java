import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine()); // Command 의 수
			int v = 0; // 현재 속도
			int d = 0; // 이동 거리
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken()); // 0. 유지 1. 가속 2. 감속

				if (cmd == 0) {

				} else if (cmd == 1) { // 가속
					int a = Integer.parseInt(st.nextToken()); // 가속도
					v += a; // 이동속도 변경
				} else if (cmd == 2) { // 감속
					int a = Integer.parseInt(st.nextToken()); // 가속도
					if (a > v) { //현재 속도보다 감속할 속도가 더 클 경우, 속도는 0 m/s 가 된다.
						v = 0;
					} else {
						v -= a; // 이동속도 변경
					}
				}
				d += v;

			}
			System.out.println("#" + tc + " " + d);
		}
	}
}