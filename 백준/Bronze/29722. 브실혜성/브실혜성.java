import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        int yN = 0, mN = 0;
        if (N >= 360) {
            yN = N / 360;
        }

        N = N - (yN * 360);

        if (N >= 30) {
            mN = N / 30;
        }

        N = N - (mN * 30);

        int finalY = y + yN;
        int finalM = m + mN;
        int finalD = d + N;

        if (finalD > 30) {
            finalM += 1;
            finalD -= 30;

        }
        if (finalM > 12) {
            finalY += 1;
            finalM -= 12;
        }

        String strY = "" + (finalY);
        if (y < 10) {
            strY = "000" + (finalY);
        } else if (y < 100) {
            strY = "00" + (finalY);
        } else if (y < 1000) {
            strY = "0" + (finalY);
        }
        String strM = "" + (finalM);
        if (finalM < 10) {
            strM = "0" + (finalM);
        }
        String strD = "" + (finalD);
        if (finalD < 10) {
            strD = "0" + (finalD);
        }
        System.out.println(strY + "-" + strM + "-" + strD);


    }
}