import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        List<String> c1 = new LinkedList<>(List.of(cards1));
        List<String> c2 = new LinkedList<>(List.of(cards2));
        for (String t:goal) {
            int c1_index=c1.indexOf(t),c2_index=c2.indexOf(t);
            if(c1_index==0)
                c1.remove(0);
            
            else if(c2_index==0)
                c2.remove(0);
            
            else
                return "No";
        }
        return "Yes";
    }
}