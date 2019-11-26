package chapter04;

import java.util.Scanner;

//중괄호 단위를 블럭이라고 하는데, 블럭 안에 뭘 쓸 때는 탭키를 눌러주어야한다.
public class IfElse01 {
	public static void main(String[] args) {
		//제어문
		// 1. 조건문
		// 	- if~else
		//	- switch~case
		// 2. 반복문
		//	-for(반복 횟수가 정해졌을때)
		//	-while(반복횟수가 정해져있지 않을 때)
		// if(조건문) { 
		// 조건문이 참인경우 실행됨
		// } else if(조건문){
		//	else if 조건문이 참인 경우 실행됨
		// } else {조건문결과 제외하고 전부 다 실행
		// }
		//
		//
		//
		//
		
			Scanner sc = new Scanner(System.in);
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒군대갈래? ver1.0");
			System.out.println("▒▒번호를 입력하세요.");
			System.out.print("▒▒(1:남성, 2:여성)>>");
			int num = sc.nextInt();
			//1:남성, 2:여성
			if(num == 1) {
				System.out.println("군대 잘 다녀오세용ㅇㅂㅇ/");
			} else if(num == 2) {
				System.out.println("군대 안 가도 돼용ㅇㅂㅇ/");
			} else {
				System.out.println("1과 2만 입력해주세요.");
			}
			
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
	}


}

