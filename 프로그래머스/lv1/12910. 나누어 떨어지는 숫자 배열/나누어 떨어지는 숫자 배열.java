import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%divisor==0){
                answer.add(arr[i]);
            }
        }
        if(answer.isEmpty())
            answer.add(-1);
        System.out.println(answer);
        int[] intAnswer = Arrays.stream(answer.stream().mapToInt(Integer::intValue).toArray()).sorted().toArray();
        return intAnswer;
    }
}