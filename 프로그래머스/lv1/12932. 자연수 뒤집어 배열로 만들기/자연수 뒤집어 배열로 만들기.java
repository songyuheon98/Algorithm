import java.util.*;
class Solution {

/*
* 자연수 뒤집어 배열로 만들기
문제 설명
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.*/

    // input
    // 자연수 n
    //
    // 계산
    // 자연수 n을 뒤집기 reverse()
    // 숫자->문자열  "".toString or String.valueOf()
    // 뒤집은거 배열화 필요
    //
    // output
    // 자연수 n을 뒤집어 각자리 숫자를 원소로 가지는 배열
    public int[] solution(long n) {
            int[] answer;
            ArrayList<Integer> arrInt = new ArrayList<>();

            String transStr = String.valueOf(n); //숫자n을 문자열로 변경
            StringBuilder strReverse = new StringBuilder(transStr); //reverse 사용하기 위해 생성
            strReverse = strReverse.reverse();//문자열n을 뒤집기
            String temp = strReverse.toString();
            for (int i = 0; i < strReverse.length(); i++) {
                arrInt.add(Integer.parseInt(String.valueOf(temp.charAt(i))));
            }

            return arrInt.stream().mapToInt(i->i).toArray();


    }
}