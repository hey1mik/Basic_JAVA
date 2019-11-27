package problem;

import java.util.Scanner;

public class ReversePrint {

	public static void main(String[] args) {

		/*
		 * 조건
		 * 1. 사용자가 임의의 정수를 입력
		 * 2. 사용자가 입력한 정수를 역으로 1까지 출력
		 * 
		 * 출력예제
		 * 입력 >> 5
		 * 5
		 * 4
		 * 3
		 * 2
		 * 1
		 * 
		 */
	Scanner sc = new Scanner(System.in);
	System.out.print("숫자를 입력하세요>>");
	int result = sc.nextInt();
	
		
		int num = 0;
		int goal = result - num;
		
		for(num = 0 ; num <= goal-1; num++) {
			result = goal - num;
			System.out.println(result);
		}
		
		
	}

}
