import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int n; // 배열의 크기
	static long[] tree, arr; // 세그먼트 트리와 원본 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 배열의 크기
		int m = Integer.parseInt(st.nextToken()); // 변경 연산의 개수
		int k = Integer.parseInt(st.nextToken()); // 구간 합 연산의 개수

		arr = new long[n + 1];
		tree = new long[getTreeSize()]; // 세그먼트 트리 배열 초기화
		for (int i = 1; i < n + 1; i++) {
			arr[i] = Long.parseLong(br.readLine()); // 원본 배열 입력 (인덱스 1부터)
		}

		init(1, n, 1); // 세그먼트 트리 초기화
		while (true) {
			if (m == 0 && k == 0)
				break;

			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			if (op == 1) {
				int idx = Integer.parseInt(st.nextToken()); // 변경할 위치
				long num = Long.parseLong(st.nextToken()); // 변경할 값

				long dif = num - arr[idx]; // 변경된 값과 기존 값의 차이 계산
				update(1, n, 1, idx, dif); // 세그먼트 트리 업데이트
				arr[idx] = num; // 배열 값 업데이트

				m--; // 변경 연산 횟수 감소

			} else {
				int left = Integer.parseInt(st.nextToken()); // 구간 합의 시작 인덱스
				int right = Integer.parseInt(st.nextToken()); // 구간 합의 끝 인덱스

				long sum = pSum(1, n, 1, left, right); // 구간 합 계산
				sb.append(sum + "\n");

				k--; // 구간 합 연산 횟수 감소
			}
		}

		System.out.println(sb.toString());
	}

	// 1. 트리 사이즈 구하기
	static int getTreeSize() {
		int h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
		return (int) Math.pow(2, h); // 인덱스 1부터
	}

	// 2. 리프노드에 원본 데이터 입력하기
	static long init(int start, int end, int node) {

		// 리프노드에 도달했을 경우, 리프노드에 원본 데이터를 입력한다.
		if (start == end)
			return tree[node] = arr[start];

		// 리프노드가 아니라면, 자식노드로 이동하여 구간 합을 더한다.
		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}

	// 3. 데이터 업데이트하기
	static void update(int start, int end, int node, int idx, long diff) {

		// 업데이트할 구간에 현재 노드가 속한다면
		if (start <= idx && idx <= end) {
			tree[node] += diff; // 현재 노드에 변경된 값만큼 더한다.
		} else
			return; // 업데이트할 구간에 현재 노드가 속하지 않으면 재귀 종료

		// 리프노드에 도달했을 경우, 재귀 종료
		if (start == end)
			return;

		// 리프노드가 아니라면, 자식노드로 이동하여 업데이트를 수행한다.
		int mid = (start + end) / 2;
		// 왼쪽 자식과 오른쪽 자식으로 나누어 업데이트를 수행한다.
		update(start, mid, node * 2, idx, diff);
		update(mid + 1, end, node * 2 + 1, idx, diff);

	}

	// 4. 구간값 구하기 : [ l ~ r ] 구간 합 구하기
	static long pSum(int start, int end, int node, int l, int r) {

		// (1) [ l ~ r ]이 [ start ~ end ]와 겹치지 않는 경우
		if (r < start || l > end)
			return 0;

		// (2) [ l ~ r ]이 [ start ~ end ]를 완전히 포함하는 경우
		if (l <= start && end <= r)
			// 구간 합 반환
			return tree[node];

		// (3) [ start ~ end ]가 [ l ~ r ]를 완전히 포함하는 경우
		// (4) [ l ~ r ]와 [ start ~ end ]가 겹쳐져 있는 경우
		// 자식노드로 이동하여 왼쪽 자식과 오른쪽 자식의 구간 합을 더한다.
		int mid = (start + end) / 2;
		return pSum(start, mid, node * 2, l, r) + pSum(mid + 1, end, node * 2 + 1, l, r);
	}
}