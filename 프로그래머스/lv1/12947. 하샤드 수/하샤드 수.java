class Solution {
    public boolean solution(int x) {
        int sum = 0,temp_x=x;
        while(x!=0){
            sum+=(x%10);
            x/=10;
        }
        if((temp_x%sum)==0)
            return true;
        else 
            return false;
    }
}
