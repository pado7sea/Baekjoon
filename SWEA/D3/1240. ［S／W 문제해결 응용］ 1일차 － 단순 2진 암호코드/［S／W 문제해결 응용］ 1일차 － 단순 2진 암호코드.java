import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][M];
			
			// 직사각형 배열 입력
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(temp.charAt(j) + "");
				}
			}

			// 둘러싼 0들 속에서 암호코드가 어디에 있는지 찾자
			int idxR = 0; // 암호코드의 시작 행 인덱스
			int idxC = 0; // 암호코드의 시작 열 인덱스
			
			// 오른쪽 아래부터 역방향 순회하면서 1이 처음 나타나는 인덱스를 찾음(암호코드 각 숫자의 마지막은 모두 1이다)
			for (int i = N - 1; i >= 0; i--) {
				for (int j = M - 1; j >= 0; j--) {
					if (arr[i][j] == 1) {
						idxR = i;
						idxC = j - 55; // 암호 코드의 총 비트 수 는 56비트
						break;
					}
				}
			}

			String[] password = new String[9]; // 0번 인덱스 안쓸거라 크기 9. (주의)int로 만들면 0001101이 1101이 된다..
			
			// 찾아낸 열 인덱스 부터 7자리씩 끊어서 배열에 저장한다.(8번반복)
			for (int i = 1; i <= 8; i++) {
				String s = "";
				for (int j = 0; j < 7; j++) {
					s += String.valueOf(arr[idxR][idxC + j]);
				}
				idxC += 7;
				password[i] = s;
			}

			int checksum = 0; // (홀수 자리의 합 x 3) + (짝수 자리의 합)
			int sum = 0; // 암호코드에 포함된 숫자의 합

			// 그리고 암호화 되어있는 각 암호코드의 숫자(7자리)를 해독한다.
			for (int i = 1; i <= 8; i++) {
				int ans = -1;
				if(password[i].equals("0001101")) ans = 0;
				if(password[i].equals("0011001")) ans = 1;
				if(password[i].equals("0010011")) ans = 2;
				if(password[i].equals("0111101")) ans = 3;
				if(password[i].equals("0100011")) ans = 4;
				if(password[i].equals("0110001")) ans = 5;
				if(password[i].equals("0101111")) ans = 6;
				if(password[i].equals("0111011")) ans = 7;
				if(password[i].equals("0110111")) ans = 8;
				if(password[i].equals("0001011")) ans = 9;
				
				if (i % 2 == 1) {
					checksum += ans * 3;
					sum += ans;
				} else {
					checksum += ans;
					sum += ans;
				}
			}

			if(checksum%10 == 0) {
				System.out.println("#" + tc + " " + sum);
			}else {
				System.out.println("#" + tc + " 0");
			}
		}
	}
}