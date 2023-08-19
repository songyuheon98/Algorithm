class Solution {
    public int solution(int[][] sizes) {
        // 초기값 설정
        int row=sizes[0][0],col = sizes[0][1];
        int len=sizes.length;
        // sol row와 col 비교 1 & row와 col을 바꿔서 비교 2 둘다 만족하지 않았을때 가로 세로중 큰거는 큰거로 작은거는 작은거로 값 재설정

        for (int i = 0; i < len; i++) {
            System.out.println(""+sizes[i][0]+" "+sizes[i][1]);
            if(!((row>=sizes[i][0]&&col>=sizes[i][1])||(col>=sizes[i][0]&&row>=sizes[i][1]))){
                int big = (sizes[i][0]>=sizes[i][1])?sizes[i][0]:sizes[i][1];
                int small = (sizes[i][0]<=sizes[i][1])?sizes[i][0]:sizes[i][1];
                if(row>col) {
                    row=(row>big)?row:big;
                    col=(col>small)?col:small;
                }
                else {
                    row=(row>small)?row:small;
                    col=(col>big)?col:big;
                }
            }

        }
        System.out.println(row+" "+col);
        return row*col;
    }
}