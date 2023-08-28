class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int wildCard = 0,card=0;
        for (int i = 0; i < lottos.length; i++) 
            if(lottos[i]==0)
                wildCard++;
            else 
                for (int j = 0; j < win_nums.length; j++) 
                    if(win_nums[j]==lottos[i])
                        card++;     

        int a =((7-(wildCard+card))>6)?6:(7-(wildCard+card));
        int b = ((7-card)>6)?6:7-card;
        return new int[] { a,b};
    }
}