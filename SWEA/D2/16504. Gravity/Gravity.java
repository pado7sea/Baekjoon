import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {

			int N = sc.nextInt();
			int count = 0;
			int[] intArr = new int[N];
			int[] intCountArr = new int[N];

			for (int j = 0; j < N; j++) {
				intArr[j] = sc.nextInt();
			}
			
			//n번째 수보다 뒤에 있는 수 중에서 작은 수의 개수를 세. 그럼 n번째 줄의 꼭대기에 있는 박스의 낙차를 구할 수 있음.
			for (int j = 0; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					if (intArr[j] > intArr[k]) {
						count++;
					}
					
				}
				
				//각 줄의 꼭대기에 있는 박스의 낙차
				intCountArr[j] = count; 
				count = 0; //초기화
			}
			Arrays.sort(intCountArr);
			
			
			
			System.out.println("#" + (i + 1) + " " + intCountArr[intCountArr.length-1]);
		}
	}
}