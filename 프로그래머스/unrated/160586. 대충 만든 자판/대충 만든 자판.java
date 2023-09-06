import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        /**
         * keymap을 for 문으로 스캔하며 각 문자에 대한 최소의 value 값을 구하고 map에 저장한다.
         * 초기에 Map에 해당 문자가 없으면 바로 추가 있으면 value 값 비교한 이후 추가
         */
        int[] answer = new int[targets.length];
        Map<Character,Integer> minKeyMap = new HashMap<>();

        /**
         * 각 문자별로 최소의 클릭 개수를 key-value 형태로 저장하는 코드
         */
        for (int i = 0; i < keymap.length; i++) {
            /**
             * 각 문자열 뽑아내는 코드
             */
            char [] forTempKeyMap = keymap[i].toCharArray();
            /**
             * 각 문자열을 문자 배열로 변환
             */
            for (int j = 0; j < forTempKeyMap.length; j++) {
                /**
                 * 만약 Map에 해당 문자열이 없다면 Map에 Put
                 */
                if(!minKeyMap.containsKey(forTempKeyMap[j]))
                    minKeyMap.put(forTempKeyMap[j],j+1);
                /**
                 * Map에 해당 문자열이 있다면 비교한 다음에 더 빨리 찾을 수 있으면 교환
                 * 빠르지 않다면 무시
                 */
                else {
                    if(minKeyMap.get(forTempKeyMap[j]).intValue()>j)
                        minKeyMap.replace(forTempKeyMap[j],j+1);
                }
            }
        }

        /**
         * target에 대한 결과 갑을 합하는 코드
         */
        for (int i = 0; i < targets.length; i++) {
            char [] temp = targets[i].toCharArray();
            for (int j = 0; j < temp.length; j++) {
                /**
                 * 해당 문자가 Keymap에 없을시 -1 리턴
                 */
                if(minKeyMap.get(temp[j])==null) {
                    answer[i] = -1;
                    break;
                }
                answer[i]+=minKeyMap.get(temp[j]).intValue();
            }
        }
        return answer;
    }
}