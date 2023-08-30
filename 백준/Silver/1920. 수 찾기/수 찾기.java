import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열의 크기 N을 입력받음
        int N = Integer.parseInt(br.readLine());

        // N개의 정수를 입력받아 배열 arr에 저장
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 arr을 정렬
        Arrays.sort(arr);

        // 배열의 크기 M을 입력받음
        int M = Integer.parseInt(br.readLine());

        // M개의 정수를 입력받아 배열 arr2에 저장
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        // 각각의 arr2[i] 값이 arr 배열 안에 존재하는지 확인하고 결과를 출력
        for (int i = 0; i < M; i++) {
            int start = 0;
            int end = arr.length - 1;
            boolean check = false;
            while (start <= end) {
                int mid = (start + end) / 2;
                int key = arr2[i];

                if (key == arr[mid]) {
                    check = true;
                    break; // 찾았으면 더 이상 탐색할 필요 없음
                } else if (key > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            if (check) {
                System.out.println(1); // 존재하는 경우
            } else {
                System.out.println(0); // 존재하지 않는 경우
            }
        }
    }
}