import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		//미리 소수를 찾아두자.. tc만큼 반복해서 찾으면 시간초과
		//소수면 false.
		boolean[] prime = new boolean[1000001];
		prime[0] = true; //0은 소수아님
		prime[1] = true; //1은 소수아님
		
		
		// 소수찾기 : 에리토스테네스의 체 알고리즘
		for (int i = 2; i <prime.length; i++) { // 2부터 루트B(약수들의 중간깞)까지
			int j = 2;
			while(i*j <=1000000) {
				//i를 제외하고 i의 배수는 모두 소수가 아니다.
				prime[i*j] = true;
				j++;
			}
		}
		
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String D = sc.next();
			int A = sc.nextInt();
			int B = sc.nextInt();


			// D 들어가는 특별한 소수인지 확인
			int ans = 0;
			for (int i = A; i <= B; i++) { // A이상 B이하의 범위에서
				if (!prime[i]) { // 소수라면
					String str = i + "";
					//문자열로 바꾸어서 문자하나씩 D와 비교
					for (int j = 0; j < str.length(); j++) {
						if (D.equals(str.charAt(j) + "")) {
							ans++;
							break;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		} // tc
	}// main
}