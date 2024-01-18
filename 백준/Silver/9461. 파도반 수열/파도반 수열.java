import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] d = new long[101];

        d[1] = 1;
        d[2] = 1;
        d[3] = 1;
        d[4] = 2;
        d[5] = 2;

        for (int i = 6; i < 101; i++) {
            d[i] = d[i - 1] + d[i - 5];
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            sb.append(d[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.print(sb);

    }
}