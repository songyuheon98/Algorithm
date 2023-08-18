import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        if(arr.length!=1)
            return Arrays.stream(arr).filter(n->n!=min).toArray();
        int [] a = {-1};
        return a;
    }
}