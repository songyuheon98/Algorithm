class Solution {
    public int solution(int num) {
        long temp=num;
        for (int i = 0; i < 500; i++) {
            if(temp!=1){
                if(temp%2==0)
                    temp/=2;
                else
                    temp=temp*3+1;
            }
            else
                return i;
        }
        return -1;
    }
}