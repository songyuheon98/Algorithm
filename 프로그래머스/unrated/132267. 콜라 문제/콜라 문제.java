class Solution {
    // 설계 재귀 함수 이용
    // 개수 = 개수 /2
    // if 개수 = 1이면 return
    // n +
    public int recursion(int a, int b, int n){
        int num = (int)(n/a)*b;
        if(n<a)
            return 0;
        return num+recursion(a,b,num+n%a);
    }
    public int solution(int a, int b, int n) {
        return recursion(a,b,n);
    }
}