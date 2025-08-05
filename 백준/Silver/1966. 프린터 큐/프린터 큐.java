import java.util.*;

class Doc {
    int pri;
    int idx;
    Doc (int pri, int idx){
        this.pri = pri;
        this.idx = idx;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int t=0;t<T;t++){
            int n = sc.nextInt();
            int targetIdx = sc.nextInt();
            
            Queue<Doc> que = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
                return b-a;
            });
            
            for(int i=0;i<n;i++){
                int p = sc.nextInt();
                que.add(new Doc(p,i));
                pq.add(p);
            }
            int count = 0;
            while(!que.isEmpty()){
                Doc doc = que.poll();
                
                if(doc.pri==pq.peek()){
                    pq.poll();
                    count++;
                    
                    if(doc.idx==targetIdx){
                        System.out.println(count);
                        break;
                    }
                } else {
                    que.add(doc);
                }
            }
        }
    }
}