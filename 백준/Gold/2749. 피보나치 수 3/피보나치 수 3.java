import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int pisano = 1500000; // 피보나치 수열은 1500000의 주기를 가짐
		long index = Long.parseLong(br.readLine()) % pisano;
		
		long[] fivo = new long[pisano + 1];
		
		fivo[0] = 0;
		fivo[1] = 1;
		
		for(int i = 2 ; i <= pisano ; i++) {
			fivo[i] = (fivo[i-1] + fivo[i-2]) % 1000000; // n번째 피보나치 수를 1,000,000으로 나눈 나머지를 출력
		}
		
		System.out.println(fivo[(int)index]);
	}
}