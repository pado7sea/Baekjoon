import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] testRoom = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			testRoom[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); // 총감독관이 한 시험장에서 감시할 수 있는 응시자의 수
		int C = Integer.parseInt(st.nextToken()); // 부감독관은 한 시험장에서 감시할 수 있는 응시자의 수
		long count = 0; //long 타입
		for (int i = 0; i < N; i++) {
			int person = testRoom[i] - B; // 총감독관으로 커버불가능한 응시인원
			count++; // 총감독관은 무조건 1명 필요

			if (person > 0) {
				//나머지가 있으면 몫에 1명을 더 한 수만큼 부감독관이 필요하고
				if (person % C > 0) { 
					count += (person / C + 1);
					//나머지가 없으면 몫의 크기만큼 부감독관이 필요하다.
				} else {
					count += person / C;
				}
			}
		} // for
		System.out.println(count);
	}// main
}