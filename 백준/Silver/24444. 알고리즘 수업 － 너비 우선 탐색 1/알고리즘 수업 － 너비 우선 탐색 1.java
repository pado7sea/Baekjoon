import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] visitOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        visitOrder = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        bfs(R);

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (visitOrder[i] == -1) {
                result.append(0).append("\n");
            } else {
                result.append(visitOrder[i]).append("\n");
            }
        }

        System.out.print(result);
    }

    public static void bfs(int node) {
        for (int i = 1; i < visitOrder.length; i++) {
            visitOrder[i] = -1;
        }

        int order = 1;
        visited[node] = true;
        visitOrder[node] = order;
        queue.add(node);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int nearnode : graph[u]) {
                if (!visited[nearnode]) {
                    order++;
                    visited[nearnode] = true;
                    visitOrder[nearnode] = order;
                    queue.add(nearnode);
                }
            }
        }
    }
}