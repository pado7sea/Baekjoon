import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		int x3 = 0;
		int y3 = 0;
		int x4 = 0;
		int y4 = 0;

		for (int tc = 1; tc <= 4; tc++) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();

			x3 = sc.nextInt();
			y3 = sc.nextInt();
			x4 = sc.nextInt();
			y4 = sc.nextInt();

			if ((x2 == x3 && y2 == y3) || (x1 == x4 && y2 == y3) || (x1 == x4 && y1 == y4)
					|| (x2 == x3 && y1 == y4)) {
				System.out.println("c");
			} else if (y2 < y3 || x2 < x3 || y4 < y1 || x4 < x1) { // 안겹치는 경우 -> 4개로 가능
				System.out.println("d");
			} else if (x2 == x3 || y2 == y3 || x1 == x4 || y1 == y4) { // 선 -> 4가지 경우
				System.out.println("b");
			} else {
				System.out.println("a");
			} 
		}
	}
}