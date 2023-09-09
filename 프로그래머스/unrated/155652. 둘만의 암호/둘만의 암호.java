import java.util.HashSet;
import java.util.Set;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        Set<Character> skipSet = new HashSet<>();
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }

        for (char c : s.toCharArray()) {
            int tempIndex = index;
            char newChar = c;
            while (tempIndex > 0) {
                newChar++;
                if (newChar > 'z') {
                    newChar = 'a';
                }
                if (!skipSet.contains(newChar)) {
                    tempIndex--;
                }
            }
            answer.append(newChar);
        }

        return answer.toString();
    }
}
