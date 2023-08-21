import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 손님 수
            int M = sc.nextInt(); // M초의 시간 당 K개의 붕어빵을 만들 수 있다.
            int K = sc.nextInt();
            
            int bread = 0; //만든 붕어빵 개수
            int toGoBread = 0; // 손님들이 가지고 간 붕어빵의 개수
            String res = "Possible";

            //입력
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                queue.add(sc.nextInt()); // 손님 오는 시간을 우선순위 큐에 저장
            }
            
            
            while(!queue.isEmpty()) {
            	int time = queue.poll(); // 손님 오는 시간(젤 빠른 시간부터 정렬되어져서 나옴)
//            	bread = time*(K/M) - toGoBread; // 손님 오는 시간에 가게에 있는 빵 = 손님오는시간*초당제조하는붕빵 - 손님이가져간붕빵
            	bread = (time / M) * K - toGoBread;
            	if(bread > 0) {
            		toGoBread++; // 손님 한 분 오실 때마다 붕빵 한개씩 가져감(가져간 붕빵 총 개수가 한개씩 증가)
            	}else {
            		res = "Impossible";
            		break;
            	}
            }
            
            System.out.println("#"+tc+" "+res);
            
        }
    }
}