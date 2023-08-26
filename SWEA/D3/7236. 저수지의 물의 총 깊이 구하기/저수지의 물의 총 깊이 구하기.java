import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 저수지 크기
			String[][] arr = new String[N][N];

			// 저수지배열 입력
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = st.nextToken();
				}
			}

			// 델타
			// 왼쪽위부터 반시계방향으로
			int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
			int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };

			int ans = 0; // 저수지 물 깊이 중 제일 깊은 물 깊이

			// 순회
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 순회하다가 물 만나면
					if (arr[i][j].equals("W")) {
						int x, y;
						int count = 0; // 주변의 물 개수를 저장하는 변수
						// 8방탐색
						for (int d = 0; d < 8; d++) {
							x = i + dx[d];
							y = j + dy[d];
							// 주변에서 물 발견할 때마다
							if (x >= 0 && x < N && y >= 0 && y < N && arr[x][y].equals("W")) {
								count++;// 물 개수 카운트
							}
						}
						// 8방 돌았는데도 주변에 물이 하나도 없으면
						if (count == 0) { 
							count = 1; //둘러싼 모든 영역이 땅(G)인 경우  그 구획의 물 깊이는 1
						}
						if(count > ans) {
							ans = count;
						}
					}
				}
			}//순회포문
			System.out.println("#"+tc+" "+ans);
		}//tc
	}//main
}