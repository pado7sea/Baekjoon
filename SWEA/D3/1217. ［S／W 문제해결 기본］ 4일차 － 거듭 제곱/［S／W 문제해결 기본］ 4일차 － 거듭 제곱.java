import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#" + tc + " " + power(N,M));

		}

	}
	
	public static int power(int N, int M) {
		// 1. 기본파트
		if(M == 0) {
			return 1;
		}
		// 2. 재귀파트 
		N *= power(N, M-1);
		
		return N;
	}
}
