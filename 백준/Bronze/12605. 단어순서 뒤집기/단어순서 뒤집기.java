import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = Integer.parseInt(sc.nextLine());

		String[] str = new String[n];
		String[] Words = new String[str.length];
		String[] res = new String[n];

		for (int i = 0; i < n; i++) { 
			str[i] = sc.nextLine();

			Words = str[i].split(" ");

			String[] reverseWords = new String[Words.length];

			for (int j = 0; j < Words.length; j++) {
				reverseWords[j] = Words[(Words.length - 1) - j];

			}
			res[i] = String.join(" ", reverseWords);
		}

		for (int i = 0; i < n; i++) { 
			System.out.println("Case #" + (i + 1) + ": " + res[i]);
		}

	}
}