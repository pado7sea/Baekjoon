import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String str;
    static int n, l, cnt;
    static boolean[] visited;
    static Character[] charArr;
    static Character[] ansArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) { // 여기 참고함ㅜㅜ
            StringTokenizer st = new StringTokenizer(line);
            str = st.nextToken();
            n = Integer.parseInt(st.nextToken());
            cnt = 0;
            l = str.length();
            visited = new boolean[l];
            charArr = new Character[l];
            ansArr = new Character[l];

            for (int i = 0; i < l; i++) {
                charArr[i] = str.charAt(i);
            }
            func(0);

            if (cnt < n) {
                System.out.println(str + " " + n + " = No permutation");
            }
        }

    }

    public static void func(int depth) {
        if (depth == l) {
            cnt++;
            if (cnt == n) {
                System.out.print(str + " " + n + " = ");
                for (int i = 0; i < l; i++) {
                    System.out.print(ansArr[i]);
                }
                System.out.println();
            }
            return;
        }

        for (int i = 0; i < l; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ansArr[depth] = charArr[i];
                func(depth + 1);
                visited[i] = false;
            }
        }


    }

}