import java.util.*;
class Solution {
    public int s1(int index){
        return index%5+1;
    }
    public int s2(int index){
        switch (index%8){
            case 0,2,4,6,8:
                return 2;
            case 1:
                return 1;
            case 3:
                return 3;
            case 5:
                return 4;
            case 7:
                return 5;
        }
        return -1;
    }
    
    public int s3(int index){
        switch(index%10){
            case 0,1:
                return 3;
            case 2,3:
                return 1;
            case 4,5:
                return 2;
            case 6,7:
                return 4;
            case 8,9:
                return 5;
        }
        return -1;
    }

    public int[] solution(int[] answers) {
        List<Integer> answer = new LinkedList<>();
        
        int []temp=new int[3];
        for (int i = 0; i < answers.length; i++) {
            temp[0]+=(answers[i]==s1(i))?1:0;
            temp[1]+=(answers[i]==s2(i))?1:0;
            temp[2]+=(answers[i]==s3(i))?1:0;
        }
        int max = Arrays.stream(temp).max().getAsInt();
        for (int i = 0; i<temp.length; i++)
            if(temp[i]==max)
                answer.add(i+1);
        return answer.stream().mapToInt(n->n).toArray();
    }
}