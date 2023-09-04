import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;             // 전체 자연수의 범위
    static int M;             // 선택할 자연수의 개수
    static int arr[];         // 선택한 자연수를 저장하는 배열
    static boolean check[];   // 자연수 사용 여부를 체크하는 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        N = Integer.parseInt(st.nextToken());   // 전체 자연수의 범위
        M = Integer.parseInt(st.nextToken());   // 선택할 자연수의 개수

        // 배열 초기화
        arr = new int[M];           // M개의 자연수를 저장할 배열 초기화
        check = new boolean[N + 1]; // 자연수 사용 여부를 체크할 배열 초기화

        // 백트래킹 알고리즘 실행
        backtracking(0);

    }

    public static void backtracking(int idx) {

        // 기저파트: M개의 수를 선택 완료하면 결과 출력
        if (idx == M) {
            // M번 반복해서 M개의 자연수 수열 출력
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // 재귀파트: N개의 자연수 중에서 조건에 맞게 선택
        for (int i = 1; i <= N; i++) {
            // 아직 해당 수를 선택하지 않았다면
            if (!check[i]) {
                check[i] = true; // 해당 인덱스의 값을 방문 상태로 체크
                arr[idx] = i;   // 배열에 해당 수를 저장
                backtracking(idx + 1); // 다음 자리 탐색

                // 재귀함수 호출이 끝나고 돌아오면 해당 인덱스의 값을 다시 방문하지 않는 상태로 변경
                check[i] = false;
            }
        }
    }
}