class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        // 어떻게 찾을까? 빈 것을
        // s1 for문 0 ~ 9
        // s2 55 - for 문
        
        for(int i=0;i<numbers.length;i++)
            answer-=numbers[i];
        return answer;
    }
}