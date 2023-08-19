import java.util.StringTokenizer;
class Solution {
    public String solution(String s) {
        //sol stringTokenizer이용 해서 공백 단위로 토큰화 -> 각 단어 읽어들이고 for문 이중 사용 짝수, 홀수 변화
        // ->

        String answer = "";
        StringTokenizer stringTokenizer = new StringTokenizer(s," ",true);
        while(stringTokenizer.hasMoreTokens()){
            String input = stringTokenizer.nextToken();
            for (int i = 0; i < input.length(); i++)
                answer+=(i%2==0)?Character.toUpperCase(input.charAt(i)):Character.toLowerCase(input.charAt(i));
            
        }
        System.out.println(answer);
        return answer;
    }
}