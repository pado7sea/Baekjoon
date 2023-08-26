import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), "SDHC", true);
			String trump = "SDHC";
			boolean noError = true;
			int[][] card = new int[4][14];
			while (st.hasMoreTokens()) {
				String s = st.nextToken(); // SDHC 중 하나
				int x = Integer.parseInt(st.nextToken()); // 숫자 두자리
				if (card[trump.indexOf(s)][x] != 0) {
					System.out.println("#" + tc + " ERROR");
					noError = false;
					break;
				}
				card[trump.indexOf(s)][x]++;

			}
			if (noError) {
				System.out.print("#" + tc + " "); 
				for (int i = 0; i < 4; i++) {
					int count = 0;
					for (int j = 1; j < 14; j++) {
						if (card[i][j] == 0) {
							count++;
						}
					}
					System.out.print(count+" ");
				}
				System.out.println();
			}
		} // tc
	}// main
}