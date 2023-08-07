import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] intArr = new int[9];
		int max = Integer.MIN_VALUE;
		int count = 0;
		
		for (int i = 0; i < 9; i++) {
			intArr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 9; i++) {
			if(intArr[i]>max) {
				max = intArr[i];
				count = i+1;
			}
		}
		System.out.println(max);
		System.out.println(count);
	}
}