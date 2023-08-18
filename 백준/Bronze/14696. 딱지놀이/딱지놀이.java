import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int a = sc.nextInt();
			int[] count1 = new int[5];
			for (int i = 0; i < a; i++) {
				count1[sc.nextInt()]++;
			}

			int b = sc.nextInt();
			int[] count2 = new int[5];
			for (int i = 0; i < b; i++) {
				count2[sc.nextInt()]++;
			}

			for (int i = 4; i >= 0; i--) {
				if (count1[i] > count2[i]) {
					System.out.println("A");
					break;
				} else if (count1[i] < count2[i]) {
					System.out.println("B");
					break;
				} else {
					if(i==0) {
						System.out.println("D");
					}
				}
				
				
			}
		}

	}
}