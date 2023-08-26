import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			int stand = 0; // 기립박수하고 있는 사람들 수
			int count = 0; // 고용인 수
			for(int i = 0;i<str.length();i++) {
				if(stand < i) { //i번째 사람들이 일어나기 위한 기립관객수가 부족할 때. 
					count += (i - stand); //더 필요한 관객수만큼 고용인 고용
					stand += (i - stand); // 늘어난 고용인만큼 기립관객수 늘어남.
				}
				stand += str.charAt(i) -'0'; // i번째에 기립박수 하고 있는 사람들을 누적합으로 계산
			}
			System.out.println("#" + tc + " "+count);
		} // tc
	}// main
}