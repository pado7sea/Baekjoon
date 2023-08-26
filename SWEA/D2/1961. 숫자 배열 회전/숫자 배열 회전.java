import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T =  Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 배열 크기
			int[][] grid = new int[N][N];

			// 입력
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("#"+tc+"\n");
			for (int i = 0; i < N; i++) {
				
				// 90도
				for (int j = 0; j < N; j++) {
					sb.append(grid[N - 1 - j][i]);
				}
				sb.append(" ");
				// 180도
				for (int j = 0; j < N; j++) {
					sb.append(grid[N - 1 - i][N - 1 - j]);
				}
				sb.append(" ");
				// 270도
				for (int j = 0; j < N; j++) {
					sb.append(grid[j][N - 1 - i]);
				}
				sb.append("\n");
				
			}
			System.out.print(sb);
			sb.delete(0, sb.length()); // 스빌에 저장된 문자열을 0번인덱스부터 sb.length() 직전 인덱스까지 삭제(스빌초기화)
		}
	}
}