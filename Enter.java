package problem;

import java.util.Scanner;

public class Enter {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력>>");
		int num = sc.nextInt();
		int num1 = num/100;
		int num2 = num%10;
		int num3 = (num-(num1*100)-(num%10));
		int num4 = num3/10;
				
		int sum = num1 + num4 + num2;
		System.out.println(sum);
		
		
	}

}
