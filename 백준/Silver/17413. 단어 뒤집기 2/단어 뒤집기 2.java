import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "< >",true);
		StringBuilder sb = new StringBuilder();
		
		Stack <Character> stack = new Stack<>();
		
		// false이면 꺽쇠 밖, true이면 꺽쇠 안
		boolean flag = false;
		
		while(st.hasMoreTokens()) {
			String str = st.nextToken();
			char ch = str.charAt(0);
			
			//여는 꺽쇠가 나오면 true로 바꿈
			if(ch == '<') {
				flag = true;
				
				//닫는 꺽쇠가 나오면 false로 바꾸고 스빌에 닫는 꺽쇠 추가
			}else if(ch == '>') {
				flag = false;
				sb.append(str);
				continue;
			}
			
			//flag가 true이면 스빌에 문자열 추가(여는 꺽쇠 포함)
			if(flag) {
				sb.append(str);
				//flag가 false이면 뒤집은 다음에 문자열 추가
			}else if(!flag) {
				
				for(int i = 0; i<str.length();i++) {
					stack.add(str.charAt(i));
				}
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			}
		}//while
		System.out.println(sb);
	}//main
}