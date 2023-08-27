import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// w*h 격자공간
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		// 초기 좌표값 (p,q)
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		// 개미가 움직일 시간
		int t = Integer.parseInt(br.readLine());
		
		//p좌표는 열길이의 2배의 시간만큼 이동하면 제자리로 돌아온다.
		//최종적으로 2배의 열길이로 나눈 나머지만큼의 시간동안만 움직인 죄표를 구하면 된다.
		p += t%(2*w); 
		//배열 밖이면
		if(p>w) p = Math.abs(2*w - p);
		
		//마찬가지
		q += t%(2*h); 
		if(q>h) q = Math.abs(2*h - q);
		
		System.out.println(p+" "+q);
		
	}
}