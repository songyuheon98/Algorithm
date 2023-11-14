import java.util.Scanner;
import java.io.FileInputStream;


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
			char[] temp = sc.nextLine().toCharArray();
			int result =1,n=temp.length;
			
			for(int i =0 ;i<n;i++)
				if(temp[i]!=temp[n-i-1])
					result=0;
			
			System.out.println("#"+test_case+" "+result);
		}
	}
}