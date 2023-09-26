import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] visited; // 몇번째로 방문했는지 저장하는 배열 (한번 방문할 때마다 1초씩 걸리니까 방문순서=방문시간임)
	static int minTime; // 동생 찾았을 때의 최소 방문시간을 저장하는 변수
	static int cnt; // 동생을 찾는 방법의 수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 수빈의 위치
		K = Integer.parseInt(st.nextToken()); // 동생의 위치

		bfs(N);
		System.out.println(minTime);
		System.out.println(cnt);
	}

	public static void bfs(int x) {
		visited = new int[100001]; // 위치 0~100000
		
		for (int i = 0; i < 100001; i++) {
			visited[i] = -1; // 방문 배열 초기화
		}
		
		Queue<Integer> que = new LinkedList<>();
		que.add(x);
		visited[x] = 0;

		while (!que.isEmpty()) {

			int current = que.poll();

			if (current == K) {
				minTime = visited[current];
				cnt++;
			}

			// 다음 위치가 범위 내이고, 방문하지 않았거나 더 작은 값이라면 값 갱신!
			if (current - 1 >= 0 && (visited[current - 1] == -1 | visited[current - 1] == visited[current] + 1)) {
				visited[current - 1] = visited[current] + 1; // 방문 횟수 증가
					que.add(current - 1); // 큐에 추가
			}

			if (current + 1 <= 100000 && (visited[current + 1] == -1 | visited[current + 1] == visited[current] + 1)) {
				visited[current + 1] = visited[current] + 1; // 방문횟수 증가
					que.add(current + 1); // 큐에 추가
			}

			if (current * 2 <= 100000 && (visited[current * 2] == -1 | visited[current * 2] == visited[current] + 1)) {
				visited[current * 2] = visited[current] + 1;
					que.add(current * 2); // 큐에 추가
			}
		}
	}
}