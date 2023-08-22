import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 스위치 개수
		StringTokenizer st = new StringTokenizer(br.readLine()); // 각 스위치의 상태

		int[] light = new int[N + 1];
		for (int i = 1; i <= N; i++) { // 각 스위치의 상태를 배열에 저장
			light[i] = Integer.parseInt(st.nextToken());
		}

		int studentN = Integer.parseInt(br.readLine()); // 학생 수

		for (int i = 0; i < studentN; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st2.nextToken()); // 성별
			int b = Integer.parseInt(st2.nextToken()); // 받은 수

			// 남학생
			if (a == 1) {
				for (int j = 1; j <= N; j++) { // 각 스위치의 상태를 배열에 저장
					if (j % b == 0) { // 스위치 번호가 남학생이 받은 수의 배수이면,그 스위치의 상태를 바꾼다
						light[j] = (light[j] + 1) % 2; // 0->1, 1->0
					}
				}

				// 여학생
			} else {
				int range = 0; // 좌우가 대칭이면서 가장 많은 스위치를 포함하는 범위를 저장하는 변수
				for (int j = 1; j <= N; j++) {
					int k = 0;
					while (b - k >= 1 && b + k <= N) { // 스위치 배열 내부에 있을 때
						if (light[b - k] == light[b + k]) { // k를 하나씩 늘려가면서 스위치 양 옆 값을 비교함
							range = k++; // 양 옆 값이 같다면 그 때의 k를 range에 저장.
						} else {
							break; // 양 옆 값이 같지 않다면 break;
						}
					}
				}
				for (int j = b - range; j <= b + range; j++) {
					light[j] = (light[j] + 1) % 2; // 0->1, 1->0
				}
			}

		}

		// 출력
		for (int i = 1; i <= N; i++) {
			sb.append(light[i] + " ");
			if (i % 20 == 0) { // 출력이 20개일때마다 엔터
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}
}
