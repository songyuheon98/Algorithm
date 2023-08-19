class Solution {
    public int dfs(int start,int len,int count,int []number,int sum,int[] temp){
        if(count==2) {
            if (sum == 0) {
                temp[0]+=1;
                return 1;
            }
            return 0;
        }
        for (int i = start; i < len; i++) {
            int sum_dfs = sum;
            sum_dfs += number[i];
            dfs(i + 1, len, count + 1, number, sum_dfs,temp);
        }
        return 0;
    }
    public int solution(int[] number) {
        int [] temp = {0};
        int answer=0,len =number.length,result=0;
        
        for (int i = 0; i < len; i++) 
            dfs(i+1,len,0,number,number[i],temp);
        
        return temp[0];
    }
}