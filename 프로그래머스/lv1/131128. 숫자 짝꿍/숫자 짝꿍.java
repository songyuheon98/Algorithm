import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public String solution(String X, String Y) {
        
        HashMap<Character, Integer> yFreq = new HashMap<>();
        
        for (char ch : Y.toCharArray()) {
            yFreq.put(ch, yFreq.getOrDefault(ch, 0) + 1);
        }
        
        PriorityQueue<Character> priQueue = new PriorityQueue<>((a, b) -> b - a);
        
        for (char ch : X.toCharArray()) {
            if (yFreq.getOrDefault(ch, 0) > 0) {
                priQueue.add(ch);
                yFreq.put(ch, yFreq.get(ch) - 1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!priQueue.isEmpty()) {
            sb.append(priQueue.poll());
        }

        String answer = sb.toString();

        if (answer.isEmpty())
            return "-1";
        else if (answer.replace("0", "").isEmpty())
            return "0";
        return answer;
        
    }
}