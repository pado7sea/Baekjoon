import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N; // 팀원의 수 (짝수)
	static int[][] team; // 능력치 저장 배열
	static boolean[] visited; // 방문여부 저장 배열
	static int min;	// 능력치 차이의 최솟값

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		team = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;
		comb(0, 0);
		calculateMin();

		System.out.println(min);
	}

	// 팀에서 절반 뽑는 메서드
	private static void comb(int depth, int start) {
		// 기저파트
		if (depth == N / 2) { // 절반 뽑으면 재귀 종료 (visited배열의 절반이 true인 상태)
			calculateMin();
			return;
		}

		// 재귀파트
		for (int i = start; i < N; i++) {
			if (visited[i])
				continue; // 이미 뽑은 선수는 건너 뛴다.

			visited[i] = true; // 뽑은 선수는 방문처리
			comb(depth + 1, i + 1); // depth +1 -> 다음 선수 뽑기, i+1 -> 현재 뽑았던 선수는 뽑지 않는다.
			visited[i] = false; // 원상복구

		}

	}

	// 스타트팀과 링크팀의 능력치 차이가 최소일 때를 계산하는 메서드
	private static void calculateMin() {
		int start = 0; // 스타트팀 능력치 합
		int link = 0; // 링크팀 능력치 합

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i] && visited[j]) {
					start += team[i][j]; //team[j][i]도 어차피 조건에 걸려서 합해짐.
				} else if (!visited[i] && !visited[j]) {
					link += team[i][j];
				}
			}
		}

		min = Math.min(min, Math.abs(start - link));

	}
}