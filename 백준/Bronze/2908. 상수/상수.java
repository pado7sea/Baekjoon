import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] c1 = st.nextToken().toCharArray();
		char[] c2 = st.nextToken().toCharArray();

		String s = "";
		String s2 = "";
		for(int i = 2 ;i>=0;i--) {
			s += c1[i];
			s2 += c2[i];
		}
		int i1 = Integer.parseInt(s);
		int i2 = Integer.parseInt(s2);
		
		if(Math.max(i1, i2)==i1) {
			System.out.println(i1);
		}else {
			System.out.println(i2);
		}
		
	}
}