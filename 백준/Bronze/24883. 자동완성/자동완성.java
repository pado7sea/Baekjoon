import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		if(N.equals("N") || N.equals("n")) {
			System.out.println("Naver D2");
			return;
		}
		System.out.println("Naver Whale");
	}
}