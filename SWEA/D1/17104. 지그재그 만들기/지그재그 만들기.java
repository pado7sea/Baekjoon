import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {

		int[][] zigzag = new int[10][10];
		int num = 1;

		while (num <= 10 * 10) {
			for (int r = 0; r < 10; r++) {
				if (r % 2 == 0) { // 홀수 행{
					for (int c = 0; c < 10; c++) {
						zigzag[r][c] = num++;
					}
				}else {
					for(int c = 9; c >=0; c--) {
						zigzag[r][c] = num++;
					}
				}
			}
		}
		
		//출력
		for(int r = 0; r < 10; r++) {
			for(int c =0 ; c<10;c++) {
				System.out.print(zigzag[r][c]+" ");
			}
			System.out.println();
		}
	}
}
