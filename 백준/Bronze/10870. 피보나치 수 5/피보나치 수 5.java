import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(Fibonacci(n));
		
	}
	public static int Fibonacci(int n) {
		
		if(n<2) {
			return n;
		}
		return Fibonacci(n - 1) + Fibonacci(n - 2);

	}
}