class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] num = new int[10];
        for(int i : numbers){
            num[i] = 1;
        }
        for(int i= 0;i<10;i++){
            if(num[i]==0) answer+=i;
        }
        return answer;
    }
}