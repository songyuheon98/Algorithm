import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        List<Integer> list = new ArrayList<>();
        for (int i : ingredient) {
            list.add(i);
        }
        
        int answer = 0;
        int i = 0;

        while (i < list.size() - 3) {
            if (list.get(i) == 1 && list.get(i + 1) == 2 && list.get(i + 2) == 3 && list.get(i + 3) == 1) {
                list.subList(i, i + 4).clear();
                answer++;
                i = Math.max(0, i - 4);
            } else {
                i++;
            }
        }

        System.out.println(answer);
        return answer;
    }
}
