import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();

		int R = 0;
		int C = 0;
		
		// R<=C이고, R*C=N인 R과 C를 고른다. 
		// 만약, 그러한 경우가 여러 개일 경우, R이 큰 값을 선택한다.
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i * j == N && i<=j) {
					R = i;
					C = j;
				}
			}

		}
		//
		String[][] letter = new String[R][C]; //행이 R개고, 열이 C개인 행렬
		String[] strArr = str.split(""); 
		// 첫 번째 행의 첫 번째 열부터 C번째 열까지 메시지를 순서대로 옮김
		int k = 0;
		for(int j = 0; j<C;j++) {
			for(int i=0;i<R;i++) {
				letter[i][j] = strArr[k];
				k++;
			}
		}
		// 첫 번째 열의 첫 번째 행부터 R번째 행까지 차례대로 읽으면서 다시 받아 적는다.
		for(int i = 0; i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(letter[i][j]);
			}
		}
		
	}
}
