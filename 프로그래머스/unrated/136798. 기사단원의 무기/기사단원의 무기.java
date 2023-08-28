class Solution {
    // number = 기사의 수 : 기사 1 ~ number
    // limit = 초과 시 power
    public int solution(int number, int limit, int power) {
        int answer=0;
        for (int i = 1; i < number+1; i++) {
            int k=0;
            for (int j = 1; j*j <i+1; j++) { // k = 약수 개수
                if(i%j==0){ // 약수 인것
                    k++;
                    if(j*j<i)
                        k++;
                }
            }
            answer+=(k>limit)?power:k; // 약수가 limit 초과면 power, 이하면 k
        }

        return answer;
    }
}