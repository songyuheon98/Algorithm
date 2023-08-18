class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();
        String result = phone_number.substring(0,len-4).replaceAll(".","*")
                +phone_number.substring(len-4,len);
        return result;
    }
}