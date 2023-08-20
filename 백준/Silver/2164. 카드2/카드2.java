import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1;i<=N;i++) {
			queue.add(i);
		}
		int i = 1;
		while(queue.size() > 1) {
			if(i%2==1) {
				queue.remove();
			}else if(i%2 ==0) {
				queue.add(queue.remove());
			}
			i++;
		}
		System.out.println(queue.peek());
		
	}
}