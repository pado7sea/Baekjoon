import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N은 입력 받을 단어의 개수
		int N = Integer.parseInt(br.readLine());
		// 그룹 단어의 개수
		int count = 0;

		// 단어 N개를 입력으로 받음
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			boolean[] check = new boolean[26]; // 알파벳 개수만큼의 boolean배열
			boolean isGroupWord = true; // 그룹 단어인지 아닌지 여부

			// 각 단어에 대해 반복문 수행
			for (int j = 0; j < str.length(); j++) {
				// boolean배열을 이용해 각 문자가 등장하면 true로 변경하여 등장여부 체크
				if (!check[str.charAt(j) - 'a']) {
					check[str.charAt(j) - 'a'] = true;
				}
				// 이전 문자와 다른 문자가 나왔을 때, 그 문자가 이미 나왔던 문자라면(boolean배열이 이미 true인 상태라면)
				else if (check[str.charAt(j) - 'a'] && str.charAt(j) != str.charAt(j - 1)) {
					//그룹단어가 아님
					isGroupWord = false;
					break;
				}
			}
			//그룹단어라면 카운트 증가
			if (isGroupWord) {
				count++;
			}

		} // for
			// 그룹단어의 수 출력
		System.out.println(count);
	}
}