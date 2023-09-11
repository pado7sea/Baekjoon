import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int houseCount;
    static List<Integer> houseCounts = new ArrayList<>(); // 각 단지 내 집의 수를 저장할 리스트

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 지도의 크기

        map = new int[N][N]; // 지도 배열
        visited = new boolean[N][N]; // 방문 여부 확인하는 배열

        // 지도에 집의 위치를 저장
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j) - '0'; // 문자를 숫자로 변환
            }
        }

        int groupCount = 0; // 단지의 수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    groupCount++;
                    houseCount = 1; // 새로운 단지 시작, 현재 집 포함
                    dfs(i, j);
                    houseCounts.add(houseCount);
                }
            }
        }

        Collections.sort(houseCounts);

        System.out.println(groupCount); // 총 단지 수 출력
        for (int x : houseCounts) {
            System.out.println(x); // 각 단지 내 집의 수 출력
        }
    }

    public static void dfs(int row, int col) {
        visited[row][col] = true;

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                continue; // 범위를 벗어나면 다음 방향으로 이동
            }

            if (map[nr][nc] == 1 && !visited[nr][nc]) {
                houseCount++; // 연결된 집 수 증가
                dfs(nr, nc); // 연결된 집으로 이동
            }
        }
    }
}