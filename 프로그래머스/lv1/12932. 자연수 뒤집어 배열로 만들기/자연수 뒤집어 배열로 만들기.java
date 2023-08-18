class Solution {
    public int[] solution(long n) {
        long num=n;
        int len = 0;
        while (num!=0)
        {
            num/=10;
            len++;
        }
        int [] answer=new int[len];
        for (int i = 0; i < len; i++) {
            answer[i]=(int)(n%10);
            n/=10;
        }
        return answer;
    }
}