class Solution {
    public int solution(String[] babbling) {
        String[] child = {"aya", "ye", "woo", "ma"};
        int answer=0;
        for (int i = 0; i < babbling.length; i++) {
            babbling[i]=babbling[i].replaceAll("ayaaya|yeye|woowoo|mama", "0");
            babbling[i]=babbling[i].replaceAll("aya|ye|woo|ma", "");
            if(babbling[i].length()==0)
                answer++;

        }
        System.out.println(answer);
        return answer;
    }
}
