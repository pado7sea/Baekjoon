import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();

		int newM = M - 45;
		if (newM < 0) {
			H -= 1;
			M = 60 + newM;
		} else {
			M = newM;
		}
		
		if(M >= 60) {
			M -= 60;
			H += 1;
		}
		if(H >= 24) {
			H -=24;
		} else if(H < 0) {
			H +=24;
		}

		System.out.print(H+" "+M);
	}
}
