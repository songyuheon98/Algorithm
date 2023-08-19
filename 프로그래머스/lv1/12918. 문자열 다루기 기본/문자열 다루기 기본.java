import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        // sol String의 length()를 이용해서 길이가 4, 6인 문자열 판별
        if(len!=4 && len !=6)
            return false;
        
        // 정규 표현식 사용해서 [0 - 9 ] 사이 값 판별
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}