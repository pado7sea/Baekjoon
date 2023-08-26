import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[] ch = new char[N];
			// 각 제목의 첫 단어만 배열에 저장
			for (int i = 0; i < N; i++) {
				ch[i] = br.readLine().charAt(0);
			}

			Arrays.sort(ch);

			int ans = 1; // 최대 문제 제목의 개수

			for (int i = 1; i < N; i++) {
				if (ch[0] != 'A') { //A가 없으면 제목으로 쓸 수 있는 게 없는 거.
					ans = 0; 
					break;
				}
				if(ch[i]-ch[i-1]==0) { //알파벳이 중복이면 포문 한번 건너뜀
					continue;
				}
				if(ch[i]-ch[i-1]==1) { //바로 다음 순서의 알파벳이 나오면 제목개수 증가
					ans++;
				}
				if(ch[i]-ch[i-1]>1) {
					break;
				}
			}

			System.out.println("#" + tc + " " + ans);
		} // tc
	}// main
}