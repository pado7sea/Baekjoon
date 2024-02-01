class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int w =3;w<=2005000;w++){
            for(int h=1;h<=2005000;h++){
                if(brown+yellow == w*h && w>=h && yellow==(w-2)*(h-2)){
                    answer[0] = w;
                    answer[1] = h;
                    return answer;
                }
            }
        }
        return answer;
    }
}