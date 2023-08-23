import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 트리 노드 총 개수
		int[][] tree = new int[N + 1][2];

		// 입력
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		// i = 부모 일때, tree[i][0] = 왼쪽 자식, tree[i][1] = 오른쪽 자식
		for (int i = 1; i <= N - 1; i++) { // 간선 개수(노드개수 -1)만큼 반복
			int parent = Integer.parseInt(st.nextToken()); // 부모
			int children = Integer.parseInt(st.nextToken()); // 자식
			if (tree[parent][0] == 0) {
				tree[parent][0] = children;
			} else {
				tree[parent][1] = children;
			}

		}

		preorder(tree, 1);
		System.out.println();
		inorder(tree, 1);
		System.out.println();
		postorder(tree, 1);
	}

	// 전위 순회 VLR
	public static void preorder(int[][] arr, int i) {
		if (i < arr.length) {
			System.out.print(i + " "); // V
			if (arr[i][0] != 0) // 왼쪽 자식 값이 0이 아니라면 (존재한다면)
				preorder(arr, arr[i][0]); // L
			if (arr[i][1] != 0) // 오른쪽 자식 값이 0이 아니라면 (존재한다면)
				preorder(arr, arr[i][1]); // R
		}
	}

	// 중위 순회 LVR
	public static void inorder(int[][] arr, int i) {
		if (i < arr.length) {
			if (arr[i][0] != 0) // 왼쪽 자식 값이 0이 아니라면 (존재한다면)
				inorder(arr, arr[i][0]); // L
			System.out.print(i + " "); // V
			if (arr[i][1] != 0) // 오른쪽 자식 값이 0이 아니라면 (존재한다면)
				inorder(arr, arr[i][1]); // R
		}
	}

	// 후위 순회 LRV
	public static void postorder(int[][] arr, int i) {
		if (i < arr.length) {
			if (arr[i][0] != 0) // 왼쪽 자식 값이 0이 아니라면 (존재한다면)
				postorder(arr, arr[i][0]); // L
			if (arr[i][1] != 0) // 오른쪽 자식 값이 0이 아니라면 (존재한다면)
				postorder(arr, arr[i][1]); // R
			System.out.print(i + " "); // V
		}
	}
}
