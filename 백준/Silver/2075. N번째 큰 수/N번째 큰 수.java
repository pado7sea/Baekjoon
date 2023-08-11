import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력
		int N = sc.nextInt();
		int[][] matrix = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				matrix[r][c] = sc.nextInt();
			}
		}

		int count = 0; // N번째 큰 수를 구하기 위한 카운트 변수
		int res = 0; // N번째 큰 수가 저장될 값

		int temp = 0;
		int[] idx = new int[N];

		while (count != N) {

			int max = Integer.MIN_VALUE; // max는 매 반복마다 새로 구해야 하니 while 문 안으로!

			// idx[] 하는 이유 : 반복문을 통해서 max값이 있는 열이 정해지면 해당하는 수는 res에 저장하고 그 수가 포함된 열의 인덱스를 1증가(idx[temp]++)시키고 다음 반복으로 넘어가는거
			for (int c = 0; c < N; c++) {
				max = Math.max(max, matrix[N - 1 - idx[c]][c]); 
				if (max == matrix[N - 1 - idx[c]][c]) {
					temp = c; //현재까지 최대값이 존재하는 열의 정보를 temp에 저장.
				}
			}
			res = matrix[N - 1 - idx[temp]][temp];
			idx[temp]++;
			count++;

		}
		System.out.println(res);

	}
}
