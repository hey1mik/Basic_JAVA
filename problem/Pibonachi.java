package problem;

import java.util.Scanner;

public class Pibonachi {

	public static void main(String[] args) {
		/*
		 * 피보나치 수열
		 * 1+1+2+3+5+8+13+21+34+55 ... 
		 */
		
		
		//int first = 1;
		//int end = 1;


		Scanner sc = new Scanner(System.in);
		
		System.out.println("원하는 인덱스를 입력하세요>>");
		int num = sc.nextInt();
		
		if(num == 1) {
			System.out.println(1);
		}
		
		int first = 1;
		int end = 1;
		int sum = first + end;
		
		System.out.println(1);
		System.out.println(1);
		
		for(int i = 2 ; i <= num; i++) {
			
			sum = end;
			end = first + end;
			first = sum;

		System.out.println(end);
			}
		

		
		}
		
	}

