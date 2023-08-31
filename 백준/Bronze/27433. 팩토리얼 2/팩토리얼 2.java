import java.util.Scanner;

public class Main {
	public static long ans =1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		factorial(N);
	}//main
	
	public static void factorial(long N) {
		if(N<=0) {
			System.out.println(ans);
			return;
		}
		ans *=N;
		factorial(N-1);
	}
}