package problem.calc;

import java.util.Scanner;

public class CalcMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculator calc = new Calculator();
		
		while(true) {
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒▒▒ 더하고 나누고 Ver1.0");
			System.out.print("▒▒▒▒ 숫자 1>>");
			int first = sc.nextInt();
			System.out.print("▒▒▒▒ 연산자(+,-,x,/)>>");
			sc.nextLine();
			String oper = sc.nextLine();
			System.out.print("▒▒▒▒ 숫자 2>>");
			int second = sc.nextInt();
			
			System.out.println(first+","+oper+","+second);
			if(oper.equals("+")) {
				calc.sum(first, second);
			} else if(oper.equals("x")) {
				calc.multi(first, second);
			} else if(oper.equals("/")) {
				calc.div(first, second);
			} else if(oper.equals("-")) {
				calc.sub(first, second);
			}
			
			// 결과출력
			System.out.println("▒▒▒▒" +first + oper + second + "=" + calc.result);
		}
	}
}
