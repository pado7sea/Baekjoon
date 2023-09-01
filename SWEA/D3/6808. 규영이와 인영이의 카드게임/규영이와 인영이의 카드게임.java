import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int[] gyu_yeong; // 규영이의 카드덱 배열
	public static int[] inn_yeong; // 원본 배열
	public static int[] result; // 생성된 순열을 저장할 배열
	public static int countWin; // 규영이가 이기는 경우
	public static int countLose;// 지는 경우
	public static int sum1; // 규영이의 점수
	public static int sum2;// 플레이어 2의 점수

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 카드 사용 여부를 체크할 배열
			boolean[] card = new boolean[19];
			// 규영 카드덱 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			gyu_yeong = new int[9];
			for (int i = 0; i < 9; i++) {
				gyu_yeong[i] = Integer.parseInt(st.nextToken());
				card[gyu_yeong[i]] = true; // 해당 카드를 사용했음을 표시
			}
			// 인영이의 카드덱은 규영이 카드덱에 없는 카드로 구성
			result = new int[9];
			inn_yeong = new int[9];
			int j = 0;
			for (int i = 1; i < card.length; i++) {
				// 규영이 카드덱에 없는 카드만 인영이 카드덱에 추가
				if (!card[i]) {
					inn_yeong[j] = i;
					j++;
				}
			}

			// 초기화
			countWin = 0;
			countLose = 0;
			sum1 = 0;
			sum2 = 0;

			perm(0, 0);
			System.out.println("#" + tc + " " + countWin + " " + countLose);
		} // tc

	}

	// 비트마스킹으로 순열 생성하는 메소드
	// idx: 현재 판단 위치, visited: 원소 사용 여부를 비트 마스크로 표시
	public static void perm(int idx, int visited) {
		if (idx == 9) {
			sum1 = 0;
			sum2 = 0;
			// 규영-인영 배열(result)의 값 비교 ->게임 결과를 계산
			game(result);
			return;
		}

		for (int i = 0; i < 9; i++) {
			if ((visited & (1 << i)) > 0)
				continue;

			result[idx] = inn_yeong[i];

			if (gyu_yeong[i] > inn_yeong[i]) {
				sum1 += (gyu_yeong[i] + inn_yeong[i]); // 규영이가 이길 경우
			} else if (gyu_yeong[i] < inn_yeong[i]) {
				sum2 += (gyu_yeong[i] + inn_yeong[i]); // 인영이가 이길 경우
			}
			// 다음 원소를 선택하고 재귀 호출
			perm(idx + 1, visited | (1 << i));
		}
	}

	// 두 플레이어의 게임 결과를 계산하는 메소드
	public static void game(int[] player2) {
		// 아홉 라운드에 걸쳐 게임을 진행
		for (int i = 0; i < 9; i++) {
			// 한 라운드에는 한 장씩 카드를 낸 다음 두 사람이 낸 카드에 적힌 수를 비교해서 점수를 계산
			if (gyu_yeong[i] > player2[i]) {
				sum1 += (gyu_yeong[i] + player2[i]);
			} else if (gyu_yeong[i] < player2[i]) {
				sum2 += (gyu_yeong[i] + player2[i]);
			}
		}
		// 규영이가 이기는 경우
		if (sum1 > sum2) {
			countWin++;
			return;
		}
		// 규영이가 지는 경우
		else if (sum1 < sum2) {
			countLose++;
		}
	}
}