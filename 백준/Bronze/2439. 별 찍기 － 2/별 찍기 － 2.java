import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int a;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		for(int i = 0; i < a; i++) {
			for(int j = a; j >0 ; j--) {
				if(i < j-1) {
					System.out.printf(" ");
				}
				else {
					System.out.print("*");
				}
				
			}
			if(i<a)
				System.out.printf("\n");
		}
	}

}