import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int[] intArr = new int[n];
			
			
			for(int i = 0; i < n; i++) {
				intArr[i] = sc.nextInt();
			}
			
			//제일 마지막 막대기는 무조건 보이니까 cnt는 1부터 시작
			int cnt = 1;
			//역순으로 비교해가다가 마지막 막대기보다 높은 게 나오면 그걸 젤 높은 막대기로 변경 (가릴 수 있으니까)
			int highest = intArr[n-1];
			for(int i = (n-2); i >= 0; i--) {
				if(intArr[i] > highest) {
					cnt++;
					highest = intArr[i];
				}
			}
			System.out.print(cnt);

	}

}