class Solution {
    public int solution(String s) {
        int startN = 0;
        char tempChar = ' ';
        int answer = 0;
        for (char c : s.toCharArray()) {
            if(startN==0){
                tempChar = c;
                startN++;
                answer++;
            }
            else
                if(tempChar==c)
                    startN++;
                else
                    startN--;
        }
        return answer;
    }
}