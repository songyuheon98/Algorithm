class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int t_len=t.length(),p_len = p.length();
        //sol t, p 입력받으면 for문으로 돌린다. 우선 p 사이즈 확보한 이후 len= t size-psize+1, substring이용해서 psize만큼 비교
        for (int i = 0; i < t_len-p_len+1; i++) {
            String str_t = t.substring(i, p.length() + i);
            if (str_t.compareTo(p)<=0)
                answer++;
        }
        System.out.println(answer);
        return answer;
    }
}