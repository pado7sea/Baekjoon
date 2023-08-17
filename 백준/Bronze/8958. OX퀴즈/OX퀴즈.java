import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();	// 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();

			int res = 0;	//점수의 합
			int count = 0;	//특정 문제의 점수
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == 'O') {
					count++;	//그 문제의 점수는 그 문제까지 연속된 O의 개수다. 
					res += count; 
				} else if (ch == 'X') { 
					count = 0; //X가 나오면 다음 문제의 점수는 다시 0점으로 초기화
				}
			}
			System.out.println(res);
		}
	}
}