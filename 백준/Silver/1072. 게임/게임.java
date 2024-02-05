import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());

        if ((Y * 100) / X >= 99) {
            System.out.println(-1);
            return;
        }

        long start = 0;
        long end = X;
        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (Math.round(100 * (Y + mid) / (X + mid)) > Math.round((Y * 100) / X)) {
                answer = mid;
                end = --mid;
            } else {
                start = ++mid;
            }
        }
        System.out.println(answer);


    }
}