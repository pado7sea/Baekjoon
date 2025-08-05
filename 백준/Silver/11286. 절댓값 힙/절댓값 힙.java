import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if(absA != absB){
                return absA - absB;
            }
            return a-b;
        });
        
        for(int i =0;i<n;i++){
            int input = sc.nextInt();
            if(input != 0){
                pq.add(input);
                 
                
            } else {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
                
            }
        }
    }
}