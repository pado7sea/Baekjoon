class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int dr[] = {0,0,-1,1};
        int dc[] = {-1,1,0,0};
        int n = board.length;
        
        for(int d = 0; d < 4 ; d++){
            int h_check = h + dr[d];
            int w_check = w + dc[d];
            if(h_check < 0 || w_check < 0 || h_check >= n || w_check >= n ){
                continue;
            }
            if(board[h][w].equals(board[h_check][w_check])){
                answer++;
            }
        }
        
        return answer;
    }
}