import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static String[] word;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc =1;tc<=10;tc++) {
		int N = Integer.parseInt(br.readLine()); // 트리 노드 총 개수
		word = new String[N + 1];

		// 입력
		// str에서 두번째 문자만 꺼내서 word[]에 인덱스 1에서부터 순차적으로 넣어놓을 거임
		for (int i = 1; i < word.length ; i++) { // 노드 개수만큼 반복
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			String dummy = st.nextToken();
			word[i] = st.nextToken();
		}
		System.out.print("#"+tc+" ");
		inorder(1);
		System.out.println();
		}
	}
	
	public static void inorder(int i) {
		
		if(i < word.length) {
			inorder(i*2);   //L
			if(word[i] != " ")
				System.out.print(word[i]); //V
			inorder(i*2+1); //R
		}else {
			return;
		}
	}
}