class Solution {
    public int solution(int[] number) {
        int answer = 0;
        // sol for문 3개 사용
        //0 1 2
        // 0 1 3
        // 0 1 4
        // 1 2 3
        // 1 2 4
        // 2 3 4

        for (int i = 0; i < number.length; i++) {
            for (int j = i+1; j < number.length; j++) {
                for (int k = j+1; k < number.length; k++) {
                    if((number[i]+number[j]+number[k])==0)
                        answer+=1;
                }
            }
        }
        
        
        
        return answer;
    }
}