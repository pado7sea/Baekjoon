import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] intArr = new int[10];
		double sum = 0;

		for (int i = 0; i < T; i++) {
			for (int j = 0; j < 10; j++) {
				intArr[j] = sc.nextInt();

			}
			Arrays.sort(intArr); // min = intArr[0] , max = intArr[9]

			for (int j = 1; j < 9; j++) {
				sum += intArr[j];
			}

			System.out.println("#" + (i + 1) + " " + Math.round(sum/8));
			sum = 0;
			
		}
		
		sc.close();
	}
}