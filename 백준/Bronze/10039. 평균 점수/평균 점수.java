import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] intArr = new int[5];
		int[] newArr = new int[5];
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			intArr[i] = sc.nextInt();
			
			if(intArr[i] < 40) {
				newArr[i] = 40;
			}else {
				newArr[i] = intArr[i];
			}
			
			sum += newArr[i];
		}
		
		System.out.print(sum/5);
		
	}
}