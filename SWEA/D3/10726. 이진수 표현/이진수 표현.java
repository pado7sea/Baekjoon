import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			String ans = "ON";
			//0부터 N개의 비트까지 확인
			for(int i = 0; i<N;i++) {
//				System.out.println("M이진수 "+Integer.toBinaryString(M));
//				System.out.println("i를 시프트"+Integer.toBinaryString(1<<i));
//				System.out.println("결과"+ Integer.toBinaryString(M &(1<<i)));
				if((M &(1<<i)) == 0) { // 연산 결과가 0이 나오면 종료
					ans = "OFF";
					break;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}