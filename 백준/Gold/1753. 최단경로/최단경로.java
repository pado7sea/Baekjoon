import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE;

    static class Edge {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int start = sc.nextInt(); 

        // 그래프 초기화
        List<List<Edge>> graph = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Edge(v, w));
        }

        int[] dist = dijkstra(V, graph, start);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    public static int[] dijkstra(int V, List<List<Edge>> graph, int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // 우선순위 큐 사용
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curNode = cur.node;
            int curWeight = cur.weight;

            if (dist[curNode] < curWeight) continue;

            for (Edge next : graph.get(curNode)) {
                int nextWeight = next.weight + curWeight;
                if (nextWeight < dist[next.node]) {
                    dist[next.node] = nextWeight;
                    pq.add(new Edge(next.node, nextWeight));
                }
            }
        }

        return dist;
    }
}