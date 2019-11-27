package gugudan;

import java.util.Scanner;

public class GuGuMain {

	public static void main(String[] args) {

		// JAVA는 프로그램 실행시 무조건
		// Main 메서드부터 시작!
		Scanner sc = new Scanner(System.in);
		int num2;

		System.out.print("1~19 단수를 입력하세요>>");
		num2 = sc.nextInt();
		while (true) {
			if (num2 >= 20 || num2 < 1) {
				System.out.println("숫자 범위를 확인해주세요");
			} else {
				break;
				}
			}
		
		GuGuPrint ggp = new GuGuPrint();
		ggp.guGuDan(num2); //갔다가 메인으로 다시오는 것! 호출!
		
	
		//1. 사용자에게 단수를 입력받는 부분
		//2. 구구단을 출력하는 부분
			
			
			
		}
	}

