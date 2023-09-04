import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int arr[];
    static boolean check[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        check = new boolean[N + 1];
        backtracking(0, 1); // 시작 숫자를 1로 지정

        System.out.println(sb);
    }

    public static void backtracking(int idx, int start) {
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[idx] = i;
                backtracking(idx + 1, i + 1); // 다음 자리 탐색 및 시작 숫자 업데이트
                check[i] = false;
            }
        }
    }
}