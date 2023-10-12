import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point {
	int r, c;

	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[] visited;
	static ArrayList<Point> chicken = new ArrayList<>();
	static Point[] selected;

	static int minTotalCD = Integer.MAX_VALUE;

	static int[] dr = { 0, 1, 0, -1 }; // 좌하우상
	static int[] dc = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		// 도시의 정보 입력 : 0은 빈 칸, 1은 집, 2는 치킨집
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 치킨집 좌표를 chicken 리스트에 저장
				if (map[i][j] == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}
		visited = new boolean[chicken.size()];
		selected = new Point[M];

		// 도시에 있는 치킨집 중에서 최대 M개를 고르는 메서드
		selectChicken(0, 0);

		// 출력
		System.out.println(minTotalCD);
	}

	// 치킨집 M개를 고르는 조합 메서드
	private static void selectChicken(int depth, int start) {
		if (depth == M) { // M개 고르면 끝
			chickenDistance(); // 치킨 거리 계산하는 메서드 호출
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[depth] = chicken.get(i); // 선택한 치킨집을 selected 배열에 저장
				selectChicken(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	private static void chickenDistance() {
		int totalCD = 0; // 도시의 치킨 거리

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) { // 집인 경우 치킨거리 계산
					int CD = Integer.MAX_VALUE; // 치킨거리는 집과 가장 가까운 치킨집 사이의 거리
					for (int k = 0; k < M; k++) {
						Point p = selected[k];
						int r = p.r;
						int c = p.c;
						CD = Math.min(CD, Math.abs(i - r) + Math.abs(j - c));
					}
					totalCD += CD;
				}
			}
		}
		minTotalCD = Math.min(minTotalCD, totalCD);
	}
}