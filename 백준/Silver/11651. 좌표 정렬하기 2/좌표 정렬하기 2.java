import java.util.*;

class Point {
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> list = new ArrayList<>();
        
        for(int i= 0; i<n;i++){
            list.add(new Point(sc.nextInt(),sc.nextInt()));
        }
        
        Collections.sort(list, (a,b)->{
           if(a.y != b.y){
               return a.y- b.y;
           } return a.x - b.x;
        });
        
        for(Point p : list){
            System.out.println(p.x+" "+p.y);
        }
        
    }
}