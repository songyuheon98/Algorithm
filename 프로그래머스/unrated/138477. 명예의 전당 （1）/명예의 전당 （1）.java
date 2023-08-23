
import java.util.*;
// class Solution {
//     public int[] solution(int k, int[] score) {
//         LinkedList<Integer> temp = new LinkedList<>();
//         int[] answer = new int[score.length];
//         for (int i = 0; i < score.length; i++) {
//             if(temp.size()<k) {
//                 temp.add(score[i]);
//                 answer[i]= (temp.stream().mapToInt(Integer::intValue).min().getAsInt());
//                 continue;
//             }
//             int min =temp.stream().mapToInt(Integer::intValue).min().getAsInt();
//                 // min 값을 쓰기 위해서는 maptoint를 통해 int형으로 바꾸어 줘야한다. Stream<Integer> -> IntStream

//             if(temp.size()>=k && score[i]>=min){
//                 temp.remove((Integer) min);
//                 temp.add(score[i]);
//             }
//             answer[i]= (temp.stream().mapToInt(Integer::intValue).min().getAsInt());
//         }
//         for (int num:answer) {
//             System.out.print(num + " ");
//         }
//         return answer;
//     }
// }



class Solution {
    public int[] solution(int k, int[] score) {
        LinkedList<Integer> temp = new LinkedList<>();
        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            temp.add(score[i]);
            temp.sort((n1,n2)->n1-n2);
            if(temp.size()==k+1)
                temp.pollFirst();

            answer[i]=temp.peekFirst();
        }

        return answer;
    }
}