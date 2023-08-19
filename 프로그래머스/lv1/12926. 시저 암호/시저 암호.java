class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] temp=s.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            if('A'<=temp[i]&&temp[i]<='Z') 
                temp[i]= ((temp[i] + n)>'Z')? (char)(temp[i]-26+n):(char)(temp[i]+n);
            else if('a'<=temp[i]&&temp[i]<='z') 
                temp[i]= ((temp[i] + n)>'z')? (char)(temp[i]-26+n):(char)(temp[i]+n);
            
        }
        System.out.println(String.valueOf(temp));
        return String.valueOf(temp);
    }
}