import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] a = new int[N];
        for(int i =0;i<N;i++){
            a[i] = sc.nextInt();
        }
        int st = 0;
        int en = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(en<N){ 
            sum = sum + a[en];
            while(sum>=S){
                
                min = Math.min(min, en-st+1);
                sum = sum - a[st];
                st++;
            }
            en++; 
            
            
            if(st>en) en = st;
        }
        
        if(min == Integer.MAX_VALUE){
            min = 0;
        }
        
        System.out.print(min);
    }
}