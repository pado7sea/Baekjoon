import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		String[] strArr = str.split("");
		int res = 0;
		for(int i = 0; i < n; i++) {
			res += Integer.parseInt(strArr[i]);
		}
		
		System.out.println(res);
	}
}