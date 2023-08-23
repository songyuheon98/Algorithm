class Solution {
    public int solution(int[] nums) {
        int answer = 0,len = nums.length,temp=0;

        for (int i = 0; i < len; i++)
            for (int j = i+1; j < len; j++)
                for (int k = j+1; k < len; k++){
                    temp=nums[i]+nums[j]+nums[k];
                    int ch =1;
                    for (int l = 2; l < temp; l++) {
                        ch = (temp%l==0)?0:1;
                        if(ch==0)
                            break;
                    }
                    if(ch==1)
                        answer++;
                }
        return answer;
    }
}