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
        for (int i = 0; i < s.length(); i++) {
            int val =Integer.parseInt(String.valueOf(s.charAt(s.length()-1-i)));
            result= (i==0)?result+val: result + (int)(val * Math.pow(3, i));
        }

        return result;
    }
}