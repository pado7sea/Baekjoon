import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0; //0의 개수
		
		if(n>=125)
			count += n/125;
		if(n>=25)
			count += n/25;
		if(n>=5)
			count += n/5;
		System.out.println(count);
		
	}
}