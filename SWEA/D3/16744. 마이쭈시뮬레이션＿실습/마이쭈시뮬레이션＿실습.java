import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//마이쮸 나누어 주기
//한번 받은 사람은 새롭게 줄을 서고 기존의 받은 양보다 한 개 더 받을 수 있다.
//사람이 줄을 서면 새로운 사람이 와서 줄을 서게 된다.
public class Solution {
	static class Person {
		int num; // 사람의 번호
		int cnt; // 현재 가지고 갈 수 있는 마이쮸 카운트

		public Person(int num) {
			this.num = num;
			this.cnt = 1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 총 마이쮸 개수
			int pNum = 1;

			Queue<Person> queue = new LinkedList<>();
			queue.add(new Person(pNum++)); // 큐에 첫 번째 사람을 넣어놓음
			while (N > 0) { // 마이쮸를 다 나눠주면 while문 종료
				Person p = queue.poll(); // 첫 번째 사람이 나감
				N -= p.cnt; // 첫번째 사람의 마이쮸 카운트를 보고 그 개수대로 마이쮸 줌.
				if (N <= 0) {
					System.out.println("#" + tc + " " + p.num); // 마지막으로 마이쮸를 챙겨간 사람의 넘버
				} else {
					p.cnt++; // 가져간 마이쮸 개수 +1 해서 큐에 저장
					queue.add(p);
					queue.add(new Person(pNum++)); // 새로 줄 설 사람
				}
			}
		}
	}
}
