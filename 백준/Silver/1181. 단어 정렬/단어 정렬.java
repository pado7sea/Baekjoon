import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력
		int N = sc.nextInt();
		String[] words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = sc.next();
		}

		//중복을 제거하기 위해 배열을 Set으로 변경
		//Arrays.asList를 통해서 배열 -> 리스트 / 그리고 리스트 -> Set
		Set<String> set = new HashSet<String>(Arrays.asList(words));
		
		//toArray()를 통해서, 다시 Set을 배열로 변경
		//배열의 크기를 0으로 지정하면 자동으로 배열의 크기가 지정된다.
		String[] newWords = set.toArray(new String[0]);
		
		//정렬
		Arrays.sort(newWords, (a, b) -> {
			int len1 = a.length();
			int len2 = b.length();

			if (len1 == len2) { // 길이가 같으면
				return a.compareTo(b); // 같으면 0, 다르면 아스키코드값으로 비교해서 그 차를 반환
			} else {
				return len1 - len2; // 그렇지 않으면 길이 순으로 오름차순 정렬
			}
		});
		
		
		// 출력
		for (int i = 0; i < newWords.length; i++) {
			System.out.println(newWords[i]);
		}
	}
}
