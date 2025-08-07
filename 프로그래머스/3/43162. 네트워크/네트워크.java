import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];

        int count = 0;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                bfs(i,computers, visited,n);
                count++;
            }
        }
        return count;
    }        




    public void bfs(int start, int[][] computers, boolean[] visited,int n){
        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        que.add(start);

        while(!que.isEmpty()){
            int c = que.poll();

            for(int i =0;i<n;i++){
                if(computers[c][i]==1&&!visited[i]){
                    que.add(i);
                    visited[i] = true;
                }
            }

        }
    }
}
