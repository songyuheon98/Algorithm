import java.util.*;
class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
        // sol for 문 중첩으로 문제 해결 + ArrayList 2차원 배열
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int len = arr1.length,len2=arr1[0].length;

        for (int i = 0; i < len; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < len2; j++) {
                row.add(arr1[i][j]+arr2[i][j]);
            }
            result.add(row);
        }
        return result.stream().map(sub->sub.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
}
}