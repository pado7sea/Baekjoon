import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력
		int N = sc.nextInt();
		int[][] dot = new int[N][2];
		for (int i = 0; i < N; i++) {
			dot[i][0] = sc.nextInt();
			dot[i][1] = sc.nextInt();
		}
		
		Arrays.sort(dot, (a, b)->{
			if(a[0] == b[0]) { // X값이 같으면
				return a[1] - b[1]; // Y기준으로 오름차순.
			}else {
				return a[0] - b[0]; // 그렇지 않으면 X기준으로 오름차순
			}
		});
		
		for (int i = 0; i < N; i++) {
			System.out.print(dot[i][0]+" ");
			System.out.print(dot[i][1]+"\n");
		}
	}
}