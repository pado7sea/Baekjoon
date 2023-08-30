import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 집합 내 원소의 개수
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N]; // 수열을 넣을 배열
			int count = 0; // 부분 수열의 합이 K가 되는 경우의 수
			// 배열에 수열 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			// 부분 수열 구하기
			// 경우의 수의 범위는 1부터 2^(집합 원소의 수)만큼(0부터 하면 공집합 포함임)
			for (int i = 1; i < (1 << N); i++) {
				int sum = 0; // 부분 수열의 합
				//검사하고 싶은 숫자 & (검사하고 싶은 자리만 1이고 나머지는 0인 숫자)
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) > 0) {
						sum+=arr[j];
					}
				}
				// 부분수열의 합이 K와 같을 때 카운트 증가시킴
				if(sum == K) count++;
			}
			//출력
			System.out.println("#"+tc+" "+count);
		}
	}
}