class Solution {
    public long solution(long n) {
        long answer = 0;
        long num=0;
        while(n>(num*num)){
            num++;
            if(n==num*num){
                answer=(num+1)*(num+1);
                return answer;
            }
        }
        return -1;
    }
}