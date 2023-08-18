import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 카드세트 1 길이
			int M = sc.nextInt(); // 카드세트 2 길이

			Queue<Integer> q1 = new LinkedList<>(); // 카드세트 1
			Queue<Integer> q2 = new LinkedList<>(); // 카드세트 2
			int[] cardSum = new int[N * M]; // 카드 두 장의 합. 모든 경우의 수를 계산해서 넣어둔 배열

			for (int i = 1; i <= N; i++) {
				q1.add(i);
			}
			for (int i = 1; i <= M; i++) {
				q2.add(i);
			}

			// 카드세트1(q1)의 맨 앞에서 카드 하나 빼서 카드세트2(q2)의 첫번째 카드랑 합하고 맨 뒤에 다시 넣음
			int k = 0;
			for (int i = 1; i <= M; i++) {
				int q2card = q2.poll();
				q2.add(q2card);
				for (int j = 1; j <= N; j++) {
					int q1card = q1.poll();
					q1.add(q1card);
					cardSum[k++] = q1card + q2card;
				}
			}

			// cardSum max값
			int max = -1;
			for (int i = 0; i < N * M; i++) {
				if (cardSum[i] > max) {
					max = cardSum[i];
				}
			}
			
			// 최빈수 카운트 배열
			int[] count = new int[max + 1];
			for (int i = 0; i < N * M; i++) {
				count[cardSum[i]]++;
			}
			// count 배열에서 제일 큰 수가 나올 경우 리스트에 저장!
			List<Integer> list = new ArrayList<>();
			int maxIdx = 0;
			int max2 = -1;
			for (int i = 0; i < count.length; i++) {
				if (count[i] > max2) {
					maxIdx = i;
					max2 = count[maxIdx];
				}
			}
			for (int i = 0; i < count.length; i++) {
			if (count[i] == count[maxIdx])
				list.add(i);
			}
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
}
