import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int a = 100 - x;
        int b = 100 - y;
        int c = 100 - (a + b);
        int d = a * b;
        int q = 0, r = 0, newC = c;

        q = d / 100;
        r = d % 100;
        newC = c + q;
        
        System.out.println(a + " " + b + " " + c + " " + d + " " + q + " " + r);
        System.out.println(newC + " " + r);


    }
}