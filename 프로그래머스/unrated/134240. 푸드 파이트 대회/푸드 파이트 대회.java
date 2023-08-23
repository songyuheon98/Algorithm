class Solution {
    // 설계
    // 재귀 함수 이용
    // int 음식 종류, int []
    public String recursion(int [] food, int food_name){
        String returnString ="";
        if(food_name==food.length) 
            return "0";
        for (int i = 0; i < food[food_name]/2; i++) 
            returnString += food_name;
        return returnString += (recursion(food, food_name + 1) +returnString);
    }
    public String solution(int[] food) {
        return recursion(food,1);
    }
}