import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i =0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        int st = 0;
        int en = 0;
        int min = Integer.MAX_VALUE;
        while(en<N){
            if(arr[en]-arr[st]>=M){
                min = Math.min(min, arr[en]-arr[st]);
                st++;
                
            } else {
                en++;
            }
            if(st>en) en = st;
          
        }
        
        System.out.print(min);
        
        
    }
    
}