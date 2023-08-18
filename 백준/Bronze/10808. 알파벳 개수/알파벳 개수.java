import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int[] count = new int[26+1];
		for(int i =0;i<str.length();i++) {
			count[str.charAt(i)-'a']++;
		}
		
		for(int i = 0; i<26;i++) {
			System.out.print(count[i]+" ");
		}
	}
}
