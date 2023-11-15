
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            String inputString = sc.nextLine();

            for (int i = 1; i <= 10; i++) {
                String temp = inputString.substring(0, i);
                boolean isPattern = true;

                for (int j = i; j <= inputString.length() - i; j += i) {
                    if (!inputString.substring(j, j + i).equals(temp)) {
                        isPattern = false;
                        break;
                    }
                }

                if (isPattern) {
                    System.out.println("#" + test_case + " " + i);
                    break;
                }
            }
        }
    }
}