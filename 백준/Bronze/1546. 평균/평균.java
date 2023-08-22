import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] num2 = new int[N];

		double sum = 0;

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			num[i] = a;
			num2[i] = a;
		}
		
		Arrays.sort(num2);
		int max = num2[num2.length-1];
		for (int i = 0; i < N; i++) {
			sum += ((double)num[i]/max)*100;
		}
		
		System.out.println(sum/N);
	}
}