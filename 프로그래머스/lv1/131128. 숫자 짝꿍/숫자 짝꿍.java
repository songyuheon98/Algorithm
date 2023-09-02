import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public String solution(String X, String Y) {
        // 문자 빈도를 저장하기 위한 HashMap을 생성합니다.
        HashMap<Character, Integer> yFrequency = new HashMap<>();

        // Y의 문자 빈도를 기록합니다.
        for (char ch : Y.toCharArray()) {
            yFrequency.put(ch, yFrequency.getOrDefault(ch, 0) + 1);
        }

        // 우선순위 큐 (최대 힙)를 사용하여 문자를 내림차순으로 정렬합니다.
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // X의 문자 중 Y에 있는 문자만 maxHeap에 추가합니다.
        for (char ch : X.toCharArray()) {
            if (yFrequency.getOrDefault(ch, 0) > 0) {
                maxHeap.add(ch);
                yFrequency.put(ch, yFrequency.get(ch) - 1);
            }
        }

        // StringBuilder를 사용하여 결과 문자열을 구성합니다.
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            sb.append(maxHeap.poll());
        }
        
        String answer = sb.toString();

        if (answer.isEmpty())
            return "-1";
        else if (answer.replace("0", "").isEmpty())
            return "0";
        return answer;
    }
}
