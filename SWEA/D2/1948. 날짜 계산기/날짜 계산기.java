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
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        int firstMonth=0;
        int firstDay=0;
        int secondMonth=0;
        int secondDay=0;

        T = sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {

            List<Integer> firstDateAndSecondDate = Arrays.stream(sc.nextLine().split(" ")).map(n -> Integer.parseInt(n))
                    .collect(Collectors.toList());

            firstMonth = firstDateAndSecondDate.get(0);
            firstDay = firstDateAndSecondDate.get(1);
            secondMonth = firstDateAndSecondDate.get(2);
            secondDay = firstDateAndSecondDate.get(3);

            LocalDate firstLocalDate = LocalDate.of(2023, firstMonth, firstDay);
            LocalDate secondLocalDate = LocalDate.of(2023, secondMonth, secondDay);

            int aFewDays = secondLocalDate.getDayOfYear() - firstLocalDate.getDayOfYear()+1;

            System.out.println("#"+test_case+" "+aFewDays);

        }
    }
}