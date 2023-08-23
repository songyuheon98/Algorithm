import java.util.*;
import java.util.stream.IntStream;


class Solution {
    public int solution(int k, int m, int[] score) {
        score = Arrays.stream(score).sorted().toArray();
        int result = 0;
        
        int len = (int)(score.length/m);
        for (int i = 0; i < len; i++) {
            int min = Arrays.stream(score,score.length-i*m-m,score.length-i*m).min().getAsInt();
            result+= min * m;
        }
        return result;
    }
}
