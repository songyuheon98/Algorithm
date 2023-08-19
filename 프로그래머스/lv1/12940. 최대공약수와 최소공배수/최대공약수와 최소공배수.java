class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        // sol 최소 공배수, 최대 공약수 구할려면 두수 곱하고 점점 --하는 형태로 구하면 될듯
        for (int i = 1,min_one=0; i <= m*n; i++) {
            if(m%i==0 && n%i==0)
                answer[0]=i;
            if(i%m==0&&i%n==0 && min_one==0){
                answer[1]=i;
                min_one++;
            }
        }
        System.out.println(""+answer[0]+answer[1]);
        return answer;
    }
}