import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] arr = new char[15][15];
		for (int i = 0; i < 5; i++) {
			String temp = br.readLine();
			for (int j = 0; j < temp.length(); j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if(arr[j][i]==0) continue;
				System.out.print(arr[j][i]);
			}
		}
	}
}