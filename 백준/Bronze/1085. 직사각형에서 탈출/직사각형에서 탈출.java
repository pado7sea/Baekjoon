import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int res = Math.min(Math.min(w-x, x-0), Math.min(h-y, y-0));
		System.out.println(res);
	}
}