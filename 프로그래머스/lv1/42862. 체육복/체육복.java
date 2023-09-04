import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        lost= Arrays.stream(lost).sorted().toArray();
        reserve= Arrays.stream(reserve).sorted().toArray();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : reserve)
            map.put(num, 2);

        for ( int num: lost)
            if (map.containsKey(num)) {
                map.replace(num, 1);
                n++;
            }

        for (int num : lost) {
            if (map.containsKey(num - 1) && map.get(num - 1) == 2) {
                map.put(num, 1);
                map.replace(num - 1, 1);
            } else if (map.containsKey(num + 1) && map.get(num + 1) == 2) {
                map.put(num, 1);
                map.replace(num + 1, 1);
            }

        }

        for (int i = 0; i < map.size(); i++)
            answer++;
        return answer+n-lost.length-reserve.length;
    }
}