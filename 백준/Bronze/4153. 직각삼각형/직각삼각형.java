import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			int[] tri = new int[3];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				tri[i] = Integer.parseInt(st.nextToken());
			}

			if (tri[0] == 0 && tri[1] == 0 && tri[2] == 0) {
				break;
			}

			Arrays.sort(tri);

			if (tri[0] * tri[0] + tri[1] * tri[1] == tri[2] * tri[2]) {
				bw.write("right\n");
			} else {
				bw.write("wrong\n");
			}

		}
		bw.close();
	}
}