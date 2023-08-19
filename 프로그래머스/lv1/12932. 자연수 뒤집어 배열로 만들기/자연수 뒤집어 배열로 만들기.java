import java.util.stream.IntStream;
class Solution {
            public int[] solution(long n) {
                long temp=n;

                String result = "";
                System.out.println("----");
                while(temp!=0){
                    result+=temp%10;
                    temp /= 10;
                }

                char []temp_result =result.toCharArray();
                int [] answer = IntStream.range(0,temp_result.length)
                        .map(i-> Integer.parseInt(String.valueOf(temp_result[i])))
                        .toArray();

                return answer;
            }
        }
