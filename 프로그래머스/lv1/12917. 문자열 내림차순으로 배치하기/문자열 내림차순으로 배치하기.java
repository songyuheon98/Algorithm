import java.util.Arrays;
class Solution {
    public String solution(String s) {
         char [] ar =s.toCharArray();
        Arrays.sort(ar);
        //Arrays.sort 이용해서 정렬한 이후
        char temp;

        for (int i = 0,len =ar.length; i < len/2; i++) {
            temp = ar[len-i-1];
            ar[len-i-1]=ar[i];
            ar[i]=temp;
        }
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i]);
        }
        return String.valueOf(ar);
    }
}