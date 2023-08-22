import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {

			int N = sc.nextInt(); // 원본 암호문의 길이
			LinkedList<Integer> cipher = new LinkedList<Integer>(); // 원본 암호문을 공백 단위로 잘라서 저장할 링크드리스트

			for (int i = 0; i < N; i++) {
				cipher.add(sc.nextInt());
			}

			int M = sc.nextInt(); // 명령어의 개수

			for (int i = 0; i < M; i++) {
				String cmd = sc.next();	// I or D or A
				int x = sc.nextInt();	// x위치 바로 다음에 y개의 숫자를 삽입
				int y = sc.nextInt();
				for (int j = 0; j < y; j++) {
					cipher.add(x + j, sc.nextInt());

				}

			}

			// 출력
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
			System.out.print(cipher.get(i)+" ");
			}
			System.out.println();
		}
	}
}
