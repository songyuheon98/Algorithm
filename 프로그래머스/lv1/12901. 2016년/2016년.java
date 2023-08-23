import java.util.*;
class Solution {
    public String solution(int a, int b) {
        Calendar now = Calendar.getInstance();
        now.set(2016,a-1,b);
        return now.getTime().toString().substring(0,4).toUpperCase().strip();
    }
}