import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int a = sc.nextInt()%42;
			
			//contains() 메서드는 특정 값이 List에 포함되어 있으면, true를 반환하고 그렇지 않으면 false를 반환합니다.
			if(!list.contains(a)) { 
				list.add(a);
			}
		}
		System.out.println(list.size());
	}
}