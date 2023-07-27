import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		String str1 = Integer.toString(A);
		String str2 = Integer.toString(B);

		String[] strArr1 = str1.split("");
		String[] strArr2 = str2.split("");

		int[] sum = new int[3];
		int res = 0;

		for (int i = 0; i < strArr2.length; i++) {
			
			for (int j = 0; j < strArr1.length; j++) {
				sum[i] *= 10;
				sum[i] += Integer.parseInt(strArr1[j]) * Integer.parseInt(strArr2[i]);
			}
			
			res *= 10;
			res += sum[i];

		}
		for(int i = strArr2.length; i > 0; i--) {
			System.out.println(sum[i-1]);
		}

		System.out.print(res);
	}
}