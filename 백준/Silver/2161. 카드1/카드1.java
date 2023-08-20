import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1;i<=N;i++) {
			queue.add(i);
		}
		int i = 1;
		while(queue.size() > 1) {
			if(i%2==1) {
				list.add(queue.remove());
			}else if(i%2 ==0) {
				queue.add(queue.remove());
			}
			i++;
		}
		
		//출력
		for(int j : list) {
			System.out.print(j+" ");
		}
		System.out.println(queue.peek());
		
	}
}