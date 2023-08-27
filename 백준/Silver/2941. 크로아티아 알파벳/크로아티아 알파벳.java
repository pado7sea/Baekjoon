import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		String str = br.readLine();
		br.close();

		// 크로아티아 알파벳
		String[] croatianAlphabet = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		// str에서 크로아티아 알파벳이 있다면 그 알파벳들을 0으로 대체
		for (int i = 0; i < croatianAlphabet.length; i++) {
			if (str.contains(croatianAlphabet[i])) {
				str = str.replace(croatianAlphabet[i],"0");
			}
		}//for
		
		//출력
		System.out.println(str.length());
		
	}// main
}