import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+", "D0", "D-", "F" };
		double[] gradeNum = { 4.3, 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0.0 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		for (int i = 0; i < grade.length; i++) {
			if (str.equals(grade[i])) {
				System.out.println(gradeNum[i]);
			}
		}
	}
}