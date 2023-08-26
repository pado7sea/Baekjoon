class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        for(int idx = 0; idx< code.length(); idx++){
           if(mode == 0){
                if(code.charAt(idx) != '1'){
                    if(idx%2 == 0){
                        answer+=code.charAt(idx);
                    }
                }else{
                    mode = (mode+1)%2;
                }
           } else{
               if(code.charAt(idx) != '1'){
                    if(idx%2 == 1){
                        answer+=code.charAt(idx);
                    }
                }else{
                    mode = (mode+1)%2;
                }
           }
        }
        if(answer.length() == 0){
            return "EMPTY";
        }
        return answer;
    }
}