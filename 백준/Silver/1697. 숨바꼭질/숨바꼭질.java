import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
		int K = Integer.parseInt(st.nextToken()); // 동생의 위치

		int result = bfs(N, K);
		System.out.println(result);
	}

	// BFS 알고리즘
	public static int bfs(int N, int K) {
		// 방문 여부를 저장할 배열. 위치 범위가 0에서 100,000까지이므로 길이 100,001인 배열 사용
		int[] visited = new int[100001];

		//수빈이의 초기 위치 N을 큐에 저장
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N); 
		visited[N] = 0; //방문 여부는 0

		// 큐가 빌 때까지 반복
		while (!queue.isEmpty()) {
			// 현재위치
			int x = queue.poll();
			
			// 만약 현재 위치 x가 동생의 위치 K와 같다면,
			if (x == K) {
				// 동생을 찾은 시간(=방문 횟수 =이동 시간)을 반환
				return visited[x];
			}

			// 수빈이가 걸어서 X-1로 이동한 경우, 이동한 위치가 범위 내이고 아직 방문하지 않았다면
			if (x - 1 >= 0 && visited[x - 1] == 0) {
				// 이동시간 1 증가
				visited[x - 1] = visited[x] + 1;
				// 이동한 위치를 큐에 저장
				queue.offer(x - 1);
			}
			// 수빈이가 걸어서 X+1로 이동한 경우, , 이동한 위치가 범위 내이고 아직 방문하지 않았다면
			if (x + 1 <= 100000 && visited[x + 1] == 0) {
				// 이동시간 1 증가
				visited[x + 1] = visited[x] + 1;
				// 이동한 위치를 큐에 저장
				queue.offer(x + 1);
			}
			
			// 수빈이가 순간이동하는 경우, 순간이동한 위치가 범위 내이고 아직 방문하지 않았다면
			if (2 * x <= 100000 && visited[2 * x] == 0) {
				// 이동시간 1 증가
				visited[2 * x] = visited[x] + 1;
				// 순간이동한 위치를 큐에 저장
				queue.offer(2 * x);
			}
		}

		return -1; // 동생을 찾을 수 없는 경우
	}
}