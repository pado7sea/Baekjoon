import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		String[] grade = { "A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P" };
		double[] gradeNum = { 4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//전공 과목별(학점*과목평점)의 합
		double creditsum = 0;
		//학점의 총합
		double sum = 0;
		
		for (int t = 0; t < 20; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 과목명 입력
			String str = st.nextToken();
			// 학점 입력
			Double credit = Double.parseDouble(st.nextToken());
			// 등급 입력
			String g = st.nextToken();
			
			// 입력 받은 등급을 등급에 따른 과목평점으로 바꾸어 배열에 저장
			for (int i = 0; i < grade.length; i++) {
				if (g.equals(grade[i])) {
					sum += (gradeNum[i] * credit);
					if (i != 9) // 등급이 P인 과목은 계산에서 제외
						creditsum += credit;
				}
			}
		}

		for (int i = 0; i < 20; i++) {
		}
		System.out.printf("%.6f\n", sum / creditsum);

	}// main
}