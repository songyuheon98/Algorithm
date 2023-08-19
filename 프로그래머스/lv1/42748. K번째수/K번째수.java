import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int [] temp = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(temp);
            answer[i]=temp[commands[i][2]-1];
        }
        return answer;
    }
}    
//class Solution {  // Sub string 이용
//    public int[] solution(int[] array, int[][] commands) {
//        int[] answer = new int[commands.length];
//        String result="";
//        for (int i = 0; i < array.length; i++)
//            result+=array[i];
//        //sol sub string하고 for문 쓰면 될 듯
//        for (int i = 0; i < commands.length; i++) {
//            String temp =(result.substring(commands[i][0]-1, commands[i][1]));
//            char [] tempChar = temp.toCharArray();
//            Arrays.sort(tempChar);
//            temp =String.valueOf(tempChar);
//            answer[i]=Integer.parseInt(temp.substring(commands[i][2]-1,commands[i][2]));
//        }
//        return answer;
//    }
//}