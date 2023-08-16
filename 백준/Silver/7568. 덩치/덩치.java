import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 전체 사람의 수

		int[][] kgcm = new int[N][N];

		for (int r = 0; r < N; r++) {
			kgcm[r][0] = sc.nextInt(); // 몸무게
			kgcm[r][1] = sc.nextInt(); // 키
		}

		// 다희 아이디어 쌔빔..ㅎㅎ ㅜㅜ
		// 순회해서 i번째보다 몸무게와 키가 모두 큰 사람들만 카운팅 해서 등수를 정하자.
		int[] count = new int[N];
		for(int i = 0; i < N; i++) {
			for(int j =0; j < N; j++) {
				if((kgcm[i][0] < kgcm[j][0]) && (kgcm[i][1] < kgcm[j][1])) {
					count[i]++;
				}
			}
		}
		
		//출력
		for(int i = 0; i < N; i++) {
			System.out.print((count[i]+1)+" ");
		}
	}
}
