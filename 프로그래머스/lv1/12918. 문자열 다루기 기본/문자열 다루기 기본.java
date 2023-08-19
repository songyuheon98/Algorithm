import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public boolean solution(String s) {
        return (s.length()!=4 && s.length() !=6)?false: Pattern.compile("[0-9]+").matcher(s).matches();
    }
}