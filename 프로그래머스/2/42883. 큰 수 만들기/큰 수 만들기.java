class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
  
        for(int i = 0; i<number.length()-k; i++){
            int max = 0;
            for(int j = idx; j<= k+i;j++){
               int m = number.charAt(j);
               if(max < m){
                   max = m;
                   idx = j+1;
               }
           }
            answer.append(max-'0');
        }
        
        
        return answer.toString();
    }
}