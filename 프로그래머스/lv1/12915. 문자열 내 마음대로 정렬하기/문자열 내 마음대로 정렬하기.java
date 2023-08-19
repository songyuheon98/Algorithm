import java.util.ArrayList;
import java.util.List;
class Solution {
    public String[] solution(String[] strings, int n) {
        ArrayList<String> str = new ArrayList<>(List.of(strings));
        str.sort(null);
        str.sort((a,b)->a.charAt(n)-b.charAt(n));
        System.out.println(str);
        // ArrayList를 String배열로 만들어야되
        return str.toArray(new String[str.size()]);
    }
}