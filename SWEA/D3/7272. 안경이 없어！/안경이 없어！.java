import java.util.Scanner;

public class Solution {
	
	static String noHole = "CEFGHIJKLMNSTUVWXYZ";
	static String oneHole = "ADOPQR";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		int T = sc.nextInt(); // 테스트케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			String str2 = sc.next();
			if(hole(str).equals(hole(str2))) {
				System.out.println("#"+tc+" SAME");
			}else {
				System.out.println("#"+tc+" DIFF");
			}
		}

	}
	
	public static String hole(String str) {
		
		String[] res = new String[str.length()];
		
		for(int i = 0; i<str.length(); i++) {
			String s = str.charAt(i)+"";
			if(noHole.contains(s)) {
				res[i] = "0";
			}else if(oneHole.contains(s)) {
				res[i] = "1";
			}else {
				res[i] = "2";
			}
		}
		return String.join("", res);
	}
}