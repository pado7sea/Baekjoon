import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = n + 1;
		for(int i = 0; i < n; i++) {
			res = res - 1;
			System.out.println(res);
			
		}
	}

}