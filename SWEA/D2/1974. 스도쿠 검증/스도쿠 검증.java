/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.ArrayList;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
  public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int status = 1;
            List<List<Integer>> num=new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                num.add(Arrays.stream(sc.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));
            }
//            num.forEach(System.out::println);

            // 가로줄 및 세로줄 체크
            for (int i = 0; i < 9; i++) {
                int[] tempR = new int[9];
                int[] tempC = new int[9];
                int[] temp33 = new int[9];
                for (int j = 0; j < 9; j++) {

                    int rowIndex = 3 * (i / 3);
                    int colIndex = 3 * (i % 3);


                    int indexR = num.get(i).get(j);
                    int indexC = num.get(j).get(i);
                    int index33 = num.get(rowIndex+j/3).get(colIndex+j%3);

                    if(tempR[indexR-1]==1||tempC[indexC-1]==1||temp33[index33-1]==1)
                        status=0;
                    if(status==0)
                        break;
                    tempR[indexR -1]+=1;
                    tempC[indexC-1]+=1;
                    temp33[index33-1]+=1;
                }
                if(status==0)
                    break;
            }
            System.out.println("#"+test_case+" "+status);
        }
    }
}