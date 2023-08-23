import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] grid = new int[1002][1002];
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine()); // 색종이의 수
		int[][] paper = new int[n][4];
		
		int count = 0;// 현재색종이를 추가함으로써 다시 계산된 면적
		int res = 0; // 이전까지의 면적

		// 색종이 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); // 색종이를 붙인 위치
			for (int j = 0; j < 4; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken()); // 0열:x좌표 1열:y좌표 2열:너비 3열:높이
			}
		}

		// 제일 나중에 추가되는 색종이부터 역순으로 면적 계산
		for (int i = n - 1; i >= 0; i--) {

			// 색종이 범위 만큼 카운트
			for (int j = paper[i][0]; j < paper[i][0] + paper[i][2]; j++) {
				for (int k = paper[i][1]; k < paper[i][1] + paper[i][3]; k++) {
					grid[j][k]++;
				}
			}
			// 0세기
			for (int j = 0; j < 1002; j++) {
				for (int k = 0; k < 1002; k++) {
					if (grid[j][k] != 0)
						count++;
				}
			}
			// 이전면적에서 갱신된 면적을 빼면 그게 그 색종이가 최종적으로 보이는 면적이다.
			stack.push(count - res);
			res = count - res;
			count = 0;
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + " ");
		}

	}
}