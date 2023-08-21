import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// 입력
			int N = Integer.parseInt(bf.readLine());
			int[] num = new int[N];

			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			// 삽입정렬 구현
			// 1. 정렬하고 싶은 값을 key에 저장
			// 2. 삽입할 위치를 찾고 뒤로 미는 작업을 하는 포문
			for (int i = 1; i < N; i++) {
				int key = num[i]; // 정렬하고 싶은 값
				int j;
				for(j = i-1; j>=0 && num[j]>key;j--) {
					num[j+1] = num[j];
				}
				num[j+1] = key;
			}
			//출력
			System.out.print("#"+tc+" ");
			for (int i = 0; i < N; i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
		}

	}
}
//+버퍼리더랑 토크나이저 연습