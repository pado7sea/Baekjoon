import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer> pi; // pi 배열
    private static String s; // 문자열 텍스트
    private static String p; // 패턴

    private static int n; // 문자열 길이
    private static int m; // 패턴 길이

    // getPi 함수 : 주어진 패턴에 대한 pi배열을 계산
    private static void getPi() {
        pi = new ArrayList<>(m);

        // 초기화
        for (int i = 0; i < m; i++) {
            pi.add(0);
        }

        int j = 0; // 일치하는 접두사의 길이
        // 패턴 순회하면서 접두사 == 접미사 최대길이 찾음
        for (int i = 1; i < m; i++) { // 1부터 시작
            while (j > 0 && p.charAt(i) != p.charAt(j)) { // 현재 위치의 문자와 j의 위치의 문자가 일치하지 않는 경우
                j = pi.get(j - 1); // pi배열에서 이전위치(j-1)를 가져와 j 업데이트
            }
            if (p.charAt(i) == p.charAt(j)) { // 현재 위치의 문자가 j의 위치 문자와 일치하는 경우
                j++; // 일치하는 접두사의 길이 1 증가
                pi.set(i, j); // pi 배열 업데이트 (각 위치 i마다 계산된 j값을 pi배열에 저장)
            }
        }
    }

    // kmp 함수 : 주어진 문자열 s에서 패턴 p를 찾고 인덱스를 반환
    public static ArrayList<Integer> kmp() {
        getPi(); // pi배열 계산
        ArrayList<Integer> ans = new ArrayList<>();

        int j = 0;
        // 문자열 순회하면서 패턴 일치하는지 확인
        for (int i = 0; i < n; i++) {
            // 현재 문자열의 문자와 패턴의 문자가 불일치한다면
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = pi.get(j - 1); // pi배열을 사용해서 다음 비교 위치로 건너뛴다
            }
            if (s.charAt(i) == p.charAt(j)) {
                if (j == m - 1) { // 패턴 끝에 도달한 경우 = 완전히 일치하는 부분을 찾은 경우
                    ans.add(i - m + 1); // 일치하는 부분의 시작 인덱스를 저장
                    j = pi.get(j); // 다음 일치하는 부분을 찾기 위해 j 업데이트
                } else { // 아직 패턴의 끝에 도달하지 않은 경우
                    j++; // 패턴의 다음 문자로 넘어감
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        p = br.readLine();

        n = s.length();
        m = p.length();

        ArrayList<Integer> matched = kmp(); // 일치하는 위치들이 저장되어있는 배열

        System.out.println(matched.size());
        for (int i : matched) {
            System.out.print((i + 1) + " ");
        }

        br.close();
    }
}