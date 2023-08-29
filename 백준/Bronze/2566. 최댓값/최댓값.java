import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[10][10];
		for (int i = 1; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = Integer.MIN_VALUE;
		int x = 0;
		int y = 0;
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (arr[i][j] > max) {
					max = arr[i][j];
					x = i;
					y = j;
				}
			}
		}
		System.out.println(max);
		System.out.println(x + " " + y);
	}
}