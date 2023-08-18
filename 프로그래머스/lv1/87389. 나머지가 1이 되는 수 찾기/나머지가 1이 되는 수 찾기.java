class Solution {
    public int solution(int n) {
        int answer = 0,x=1;
        while(true) {
            if(n%x==1) {
                answer = x;
                break;
            }
            x++;
        }
        return answer;
    }
}