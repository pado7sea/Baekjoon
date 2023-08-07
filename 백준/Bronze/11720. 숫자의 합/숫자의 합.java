import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int sum = 0;

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		
		for(int i = 0; i < N; i++) {
			sum += Integer.parseInt(str.charAt(i)+"");
		}
		System.out.println(sum);
	}
}