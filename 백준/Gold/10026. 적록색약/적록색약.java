import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static char[][] grid;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 그리드의 크기
		grid = new char[N][N]; // 그리드 배열 
		visited = new boolean[N][N]; // 방문 여부 저장 배열

		// 그리드 배열을 RGB로 채움
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = temp.charAt(j);
			}
		}

		//적록 색약이 아닌 사람
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					count++;
				}
			}
		}
		
		int RGBcount = count; // 적록 색약이 아닌 사람이 봤을 때 보이는 구역의 수
		count = 0; //구역의 수 초기화
		visited = new boolean[N][N]; //방문 여부 저장 배열 초기화

		//적록 색약 : G도 R로 보인다.
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'G') {
                	grid[i][j] = 'R';
                }
            }
        }
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					count++;
				}
			}
		}
		
		System.out.println(RGBcount+" "+count);
		
	}

	public static void dfs(int row, int col) {
		visited[row][col] = true; //방문여부 체크
		
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };

		for (int d = 0; d < 4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				continue;
			}
			
			//방문한적 없고, 시작점의 문자와 같은 문자라면 계속 쭉쭉 탐색
			if(!visited[nr][nc] && grid[nr][nc]==grid[row][col]) {
				dfs(nr,nc);
			}
		}
	}
}