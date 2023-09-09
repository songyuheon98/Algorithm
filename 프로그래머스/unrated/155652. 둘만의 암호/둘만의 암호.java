import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        int tempIndex;
        Set<Character> skipSet = new HashSet<>();
        for(char c : skip.toCharArray())
            skipSet.add(c);
        for (char c : s.toCharArray()) {
            tempIndex = index;
            char tempChar = c;
            while(tempIndex>0){
                tempChar++;
                if(tempChar>'z')
                    tempChar = 'a';
                if(!skipSet.contains(tempChar))
                    tempIndex--;
            }
            answer+=tempChar;

        }
        return answer;
    }
}