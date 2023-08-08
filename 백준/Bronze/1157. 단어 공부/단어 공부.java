import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력 받아서 다 대문자로 바꾼다.
		String str = sc.next();
		str = str.toUpperCase();
		int[] count = new int[26];

		// 문자로 잘라서 해당 알파벳 순서를 인덱스로 하는 배열에 +1
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			count[c - 'A']++;
		}
		
		// 최빈값 구하기
		int max = -1;
		int check = -1;
		for (int i = 0; i < count.length; i++) {
			
			if (count[i] > max) {
				max = count[i];
				check = i;

				// 빈도수가 같은 단어가 있다면 "?"을 출력
			} else if (count[i] == max) {
				check = -2;
			}
		}

		if (check == -2) {
			System.out.println("?");
		} else {
			System.out.println((char) (check + 'A'));
		}

	}
}