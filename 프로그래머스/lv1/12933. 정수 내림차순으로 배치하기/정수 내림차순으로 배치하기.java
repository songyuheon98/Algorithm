import java.util.Arrays;
class Solution {
    public long solution(long n) {
        long answer = 0;
        char [] arr = Long.toString(n).toCharArray();
        char temp;
        int len = arr.length;
        String result;
        
        Arrays.sort(arr);
        for (int i = 0; i < (int)(len/2); i++) {
            temp = arr[i];
            arr[i]=arr[len-i-1];
            arr[len-i-1]=temp;
        }
        result = new String(arr);
        answer = Long.parseLong(result);
        System.out.println(answer);
        return answer;
    }
}