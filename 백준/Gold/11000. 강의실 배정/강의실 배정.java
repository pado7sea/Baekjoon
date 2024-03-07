import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Study> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Study(start, end));
        }

        Collections.sort(list);

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (Study s : list) {
            //end_i ≤ start_j 일 경우 i 수업 듣고 난 뒤에 j 수업을 들을 수 있다.
            // 리스트 순회하면서 들을 수 있는 수업을 찾는다.
            if (!q.isEmpty() && q.peek() <= s.start) {
                q.poll();
                // (i수업 끝나는 시간을 빼버리고 j수업 끝나는 시간을 큐에 넣어서 해당 강의실의 종료시간을 갱신하는 느낌)
            }
            q.add(s.end);
            // (들을 수 있는 수업이 없는 경우에는 큐에서 아무것도 안빼고 추가만 하니까 새로운 강의실이 하나 더 추가되는 느낌)
        }
        //큐의 사이즈가 강의실 사이즈
        System.out.println(q.size());


    }
}

class Study implements Comparable<Study> {
    int start;
    int end;

    Study(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Study o) {
        if (this.start == o.start) { // 시작 시간이 빠른 순
            return this.end - o.end; // 시작 시간이 같다면 종료 시간이 빠른  순
        }
        return this.start - o.start;
    }
}