import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] person = new String[N][2];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			person[i][0] = st.nextToken();	//나이
			person[i][1] = st.nextToken();	//이름
		}
		
		Arrays.sort(person,(a,b)->{
			return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
		});
		for (int i = 0; i < N; i++) {
			System.out.println(person[i][0]+" "+person[i][1]);
		}
	}
}