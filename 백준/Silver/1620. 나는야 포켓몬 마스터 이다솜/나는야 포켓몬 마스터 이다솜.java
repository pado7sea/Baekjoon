import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도감에 수록되어 있는 포켓몬의 수
		int M = Integer.parseInt(st.nextToken()); // 맞춰야 하는 문제의 수

		// 도감 정보를 입력할 해시맵 2개
		HashMap<Integer, String> pokemonNum = new HashMap<>();
		HashMap<String, Integer> pokemonName = new HashMap<>();

		// 도감 정보 입력
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			pokemonNum.put(i,name);
			pokemonName.put(name, i);
		}

		// 맞춰야 하는 문제 정보 입력
		for (int i = 0; i < M; i++) {
			String question = br.readLine();
			// 입력받은 문제가 포켓몬번호인지 이름인지 파악. 
			// 숫자 1~9의 아스키 코드값은 49~57
			if(question.charAt(0)>=49 && question.charAt(0) <=57) {
				sb.append(pokemonNum.get(Integer.parseInt(question)));
			}else {
				sb.append(pokemonName.get(question));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}