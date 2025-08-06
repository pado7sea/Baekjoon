import java.util.*;

public class Main {
    static class Edge {
        int node;
        int weight;
        public Edge(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    
    static int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int start = sc.nextInt();
        
        // 정점에 대한 리스트 초기화
        List<List<Edge>> graph = new ArrayList<>(V+1);
        for(int i =0;i<=V;i++){
            graph.add(new ArrayList<>());
        }
        
        // 정점에 간선 정보 넣기 간선 정보 넣는 거니까 간선만큼 반복
        for(int i =0;i<E;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Edge(v,w));
        }
        
        int dist[] = dijkstra(V, graph, start);
        
        for(int i=1;i<=V;i++){
            if(dist[i]==INF){
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    public static int[] dijkstra(int V, List<List<Edge>> graph, int start){
        int dist[] = new int[V+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.weight-b.weight);
        pq.add(new Edge(start,0));
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int curnode = cur.node;
            int curweight = cur.weight;
            
            if(dist[curnode] < curweight){
                continue;
            }
            
            for(Edge next : graph.get(curnode)){
                int nextnode = next.node;
                int nextweight = next.weight + curweight;
                
                if(nextweight < dist[nextnode]){
                    dist[nextnode] = nextweight;
                    pq.add(new Edge(nextnode, nextweight));
                }
            }
        }
        return dist;
        
    }    
    
}