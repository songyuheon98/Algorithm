class Solution {
    public int solution(int n) {
        //sol 10진법 -> 3진법, 3진법 reverse(), 3진법 -> 10진법
        // for문 -> 3집법 문자열로
        int ten = n,result=0;
        String s="";
        while(ten!=0){
            s+=String.valueOf(ten%3);
            ten/=3;
        }
        return Integer.parseInt(new StringBuilder(s).toString(),3);
    }
}