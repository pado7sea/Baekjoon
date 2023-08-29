import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 배틀맵의 높이와 너비
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			// 배틀맵 배열 선언
			char[][] arr = new char[H][W];
			// 배틀맵 입력
			for (int i = 0; i < H; i++) {
				String temp = br.readLine();
				for (int j = 0; j < W; j++) {
					arr[i][j] = temp.charAt(j);
				}
			}
			// 명령문 입력
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();

			// 명령문 문자열
			String dir = "UDLR"; // 상하좌우
			// 탱크(방향) 문자열
			String tank = "^v<>"; // 상하좌우
			// 델타함수
			int[] dx = { -1, +1, 0, 0 }; // 상하좌우
			int[] dy = { 0, 0, -1, 1 };

			//문자열 길이만큼 반복
			for (int i = 0; i < N; i++) {
				char ch = str.charAt(i);
				if (ch == 'S') {
					for (int j = 0; j < H; j++) {
						for (int k = 0; k < W; k++) {
							// 탱크를 발견하면 탱크의 방향을 확인하고, 탱크방향에 해당하는 인덱스를 뽑아낸다.
							if (tank.contains(arr[j][k] + "")) {
								int idx = tank.indexOf(arr[j][k]);
								int nx = j + dx[idx];
								int ny = k + dy[idx];
								while(true) {
									//배열 밖이거나 강철 벽을 만나면 while문 탈출
									if(nx < 0 || nx >= H || ny < 0 || ny >= W || arr[nx][ny]=='#') {
										break;
									}
									// 벽돌 벽이라면 평지로 만들고 while문 탈출
									if(arr[nx][ny]=='*') {
										arr[nx][ny] = '.';
										break;
									}
									//포탄은 그 방향으로 계속 직진
									nx += dx[idx];
									ny += dy[idx];
								}
							}
						}
					}

				} else if (dir.contains(ch + "")) {
					// indexOf를 통해 ch에 해당하는 인덱스를 뽑아낸다. (ch가 U라면 dir문자열에서 U의 인덱스는 0)
					int idx = dir.indexOf(ch);
					// 순회하면서
					out:
					for (int j = 0; j < H; j++) {
						for (int k = 0; k < W; k++) {
							// 탱크를 발견하면 탱크가 바라보는 방향을 해당방향으로 바꾼다
							if (tank.contains(arr[j][k] + "")) {
								arr[j][k] = tank.charAt(idx);
								int nx = j + dx[idx];
								int ny = k + dy[idx];
								// 만약 해당방향의 다음칸이 배열 내이고 평지라면 위쪽 칸과 값을 바꾼다
								if (nx >= 0 && nx < H && ny >= 0 && ny < W && arr[nx][ny] == '.') {
									arr[j][k] = '.'; // 원래 있던 칸은 평지로
									arr[nx][ny] = tank.charAt(idx); // 탱크는 다음 칸으로 이동
									break out;
								}
							}
						}
					}
				}
			}

			// 출력
			System.out.print("#"+tc+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		} // tc
	}// main
}