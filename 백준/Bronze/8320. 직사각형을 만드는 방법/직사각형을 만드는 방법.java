import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int count = 0; // 직사각형의 개수
		
			// 정사각형 k개로 만들 수 있는 조합의 수 계산
			for (int i = 1; i <= N; i++) { 
				for (int j = 1; j <= N; j++) {
					if (i * j <= N && i >= j) { // 곱해서 N보다 작은 자연수가 나오면 됨
						count++;
					}
				}
			}
		bw.write(count+"");
		bw.close();
	}
}