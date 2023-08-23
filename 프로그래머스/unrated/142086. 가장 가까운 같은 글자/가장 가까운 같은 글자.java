import java.util.Arrays;
class Solution {
    public int[] solution(String s) {
        int len =s.length(),check =0;
        int [] answer = new int[len];
        Arrays.fill(answer,-1);

        char [] array = s.toCharArray();
        for (int i = 0; i < len; i++)
            for (int j = i-1; j >= 0 ; j--)
                if(array[j]==array[i]) {
                    answer[i] = i - j;
                    break;
                }
        for ( int a: answer) {
            System.out.print(a+" ");
        }
        System.out.println();
        return answer;
    }
}