import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int melon = sc.nextInt(); // 단위면적 당 참외의 개수

		int[][] geo = new int[6][6]; // 6각형 땅의 변을 저장할 배열

		// 배열에 각 변의 정보를 저장
		for (int i = 0; i < 6; i++) {
			geo[i][0] = sc.nextInt();
			geo[i][1] = sc.nextInt();
		}

		int[] count = new int[5];

		// 동서남북(1234) 방향의 변이 몇 번 나오는지 카운팅
		for (int i = 0; i < 6; i++) {
			count[geo[i][0]]++;
		}
		
		int idx1 = 0; //전체길이 인덱스 1
		int idx2 = 0; //전체길이 인덱스 2
		
		//'전체 길이'를 찾자
		for (int i = 0; i < 6; i++) {
			//가로 혹은 세로
			if (count[1] == 1) { //1이 한 번 나오면 1이 전체길이이다.
				if(geo[i][0]==1) //1의 인덱스를
					idx1 = i;	//전체길이 인덱스에 저장해준다.
			} else if (count[2] == 1) { 
				if(geo[i][0]==2)
					idx1 = i;
			}

			//세로 혹은 가로
			if (count[3] == 1) {
				if(geo[i][0]==3)
					idx2 = i;
			} else if (count[4] == 1) {
				if(geo[i][0]==4)
					idx2 = i;
			}
		}
		
		//‘전체 길이’를 찾았다면 전체 길이 인덱스에 4를 더한 값이 ‘부분 길이’가 된다. 
		//( idx + 4 )%6 로 배열 밖으로 벗어나지 않게 해주자.
		int idx3 = (idx1+3)%6; 
		int idx4 = (idx2+3)%6;
		
		//{ (전체 길이 * 전체 길이) - (부분 길이 * 부분 길이) } * 단위 면적 당 참외의 수 
		int res = ((geo[idx1][1]*geo[idx2][1])-(geo[idx3][1]*geo[idx4][1]))*melon;
		
		System.out.println(res);

	}
}
