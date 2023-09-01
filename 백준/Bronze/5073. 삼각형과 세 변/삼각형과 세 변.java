import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if(A==0 && B==0 && C==0) {
				break;
			}
			
			int max = Math.max(Math.max(A, B),C);
			
			if(max*2 < A+B+C) {
				if(A==B && B==C && A==C) {
					System.out.println("Equilateral");
				}else if(A != B && B !=C && A !=C) {
					System.out.println("Scalene");
				}else{
					System.out.println("Isosceles");
				}
			}else {
				System.out.println("Invalid");
			}
		}
		
	}// main
}