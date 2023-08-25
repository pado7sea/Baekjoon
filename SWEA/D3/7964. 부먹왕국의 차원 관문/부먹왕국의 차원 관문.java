import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st2.nextToken()); // 부먹왕국 도시 수
			int D = Integer.parseInt(st2.nextToken()); // 이동 제한 거리

			int ans = 0; // 추가로 건설해야 하는 차원관문의 최소개수
			// 연속된 0의 개수(차원관문이 없는 도시의 수)를 이동 제한거리 D로 나누면 ans을 구할 수 있다.

			// 입력
			int[] city = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				city[i] = Integer.parseInt(st.nextToken());
			}

			// 연속된 0의 개수 구하기
			int count = 0; // 연속된 0의 개수
			for (int i = 0; i < N; i++) {
				if (city[i] == 1) { // 1이 나오면
					ans += count / D; // 연속된 0의 개수를 이동제한 거리 D로 나누어 ans에 더한다.
					count = 0; // 그리고 다시 연속된 0의 개수를 저장하는 count 변수를 초기화시킨다
					continue;
				}
				count++;
			}
			ans += count / D; //배열의 끝에 이르렀을 때까지 1이 안나왔을 경우도 있으므로 배열이 끝날때까지 센 0의 개수도 계산해준다.
			

			System.out.println("#" + tc + " " + ans);

		}

	}
}