import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] intArr = new int[10];
		
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < 10; j++) {
				intArr[j] = sc.nextInt();
				
			}
			Arrays.sort(intArr);
			System.out.println("#"+ (i+1) + " "+ intArr[intArr.length-1]);
		}
	}
}