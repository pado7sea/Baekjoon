import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for (int i = 0; i < 5; i++) {
			sum += arr[i];
		}
		System.out.println(sum/5);
		System.out.println(arr[2]);
	}
}