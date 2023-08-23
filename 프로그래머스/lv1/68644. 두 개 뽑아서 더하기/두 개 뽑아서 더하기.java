import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int [] answer;
        Set<Integer> intSet = new HashSet<>();

        for( int i =0;i<len;i++)
            for(int j = i+1 ;j<len;j++)
                intSet.add(numbers[i]+numbers[j]);
        answer= intSet.stream().mapToInt(n->n).sorted().toArray();
//        answer= intSet.stream().mapToInt(n->n.intValue()).toArray();
//        answer= intSet.stream().mapToInt(Integer::intValue).toArray();
        for (int a:answer)
            System.out.println(a);
        System.out.println(answer);
        return answer;
    }
}
