class Solution {
    public int solution(int n, int m, int[] section) {
        int min = section[0],answer=1;
        for (int i = 0; i < section.length; i++) {
            if(section[i]>=min+m){
                answer++;
                min = section[i];
            }
        }
        return answer;
    }
}