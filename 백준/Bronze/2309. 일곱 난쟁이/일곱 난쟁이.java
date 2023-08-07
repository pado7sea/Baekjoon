
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> intlist = new ArrayList<>();
		int sum = 0;
		
		
		// 리스트에 값 추가, 일곱난쟁이 키를 다 더해서 sum에 저장
		for(int i = 0; i < 9; i++) {
			intlist.add(sc.nextInt());
			sum += intlist.get(i);
		}
		
		// 두 난쟁이의 키를 더했을 때 그 값이 (sum-100)과 일치하면, 리스트에서 두 요소를 제거한다.
		loop :
		for(int i = 0; i < 9-1; i++) {
			for(int j = i+1; j < 9; j++) {
				if((intlist.get(i) + intlist.get(j)) == (sum - 100)) {
					
					intlist.remove(j); //j가 더 뒤에 있는 요소라서 j를 먼저 제거해야함.
					intlist.remove(i);
					
					break loop;
				}
			}
		}
		Collections.sort(intlist);
		
		for(int x : intlist) {
			System.out.println(x);
		}
		
	}
}
