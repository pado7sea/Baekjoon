import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] box;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		res = 0;
		bfs();

		loop: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				res = Math.max(res, box[i][j]-1);

				if (box[i][j] == 0) {
					res = -1;
					break loop;
				}
			}
		}

		System.out.println(res);

	}// main

	public static void bfs() {

		Queue<Point> que = new LinkedList<>(); // 포인트 타입의 큐

		// 박스 배열에서 익어있는 토마토들이 시작 노드들이 된다.(시작노드가 여러개인거 주의!)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1) {
					visited[i][j] = true;
					que.offer(new Point(i, j));
				}
			}
		}

		while (!que.isEmpty()) {

			Point p = que.poll();

			for (int d = 0; d < 4; d++) {
				int nx = p.getX() + dx[d];
				int ny = p.getY() + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && box[nx][ny] == 0) {
					box[nx][ny] = box[p.getX()][p.getY()] + 1;
					visited[nx][ny] = true;
					que.offer(new Point(nx, ny));
				}

			}

		}

	}

}// Main

class Point {

	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
} // Point