import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 카드의 개수
		int M = Integer.parseInt(st.nextToken()); // 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int ans = 0; // M을 넘지 않고 M과 가장 가까운 세 카드의 합
		
		for (int i = 0; i < N - 2; i++) {
			for (int j = i+1; j < N - 1; j++) {
				for (int k = j+1; k < N; k++) {
					int sum = arr[i]+arr[j]+arr[k]; 
					if(sum > M) {
						continue;
					}
					if(ans <sum &&sum<=M ) {
						ans = sum;
					}
				}
			}
		}
		bw.write(ans+"");
		bw.close();
	}
}