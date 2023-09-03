import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N; // 재료의 수
	static int L; // 제한 칼로리
	static int[] score; // 맛에 대한 점수
	static int[] calory; // 칼로리
	static int best; // 가장 높은 맛에 대한 점수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리

			score = new int[N];
			calory = new int[N];
			best = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken()); // 맛에 대한 점수
				calory[i] = Integer.parseInt(st.nextToken()); // 칼로리
			}

			// 재귀 함수를 사용하여 햄버거 조합을 탐색하고 가장 높은 맛에 대한 점수 계산
			chooseBurger(0, 0, 0);

			System.out.println("#" + tc + " " + best);
		}
	}// main

	public static void chooseBurger(int index, int totalScore, int totalCalory) {
		if (totalCalory > L) {
            return; // 칼로리 제한을 초과하면 종료
        }
		
		if (index == N) {
            best = Math.max(best, totalScore); // 모든 재료를 사용한 경우, 최고 맛 점수 갱신
            return;
        }
		
		// 현재 재료를 선택한 경우
		chooseBurger(index + 1, totalScore + score[index], totalCalory + calory[index]);
		// 현재 재료를 선택하지 않은 경우
		chooseBurger(index + 1, totalScore, totalCalory);
		
	}
}