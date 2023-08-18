import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int answer = sc.nextInt()*sc.nextInt();
		
		for(int i = 0; i < 5; i++) {
			System.out.print((sc.nextInt()-answer)+" "); 
		}
		
	}
}