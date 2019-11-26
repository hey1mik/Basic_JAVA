package chapter04;

import java.util.Scanner;

public class For01 {

	public static void main(String[] args) {
		// 학점 계산 프로그램
		Scanner sc = new Scanner(System.in);
		 
		System.out.print("학생점수를 입력하세요>>>");
		int score = sc.nextInt();
		
		// 파트 1 : 학생점수 입력받는 부분
		while(true) {
		if(score > 100 || score < 0) {
			System.out.println("0과 100 사이의 값을 입력해주세요");
		} else {
			break;
			} // 0~100 들어온 경우 반복문 빠져나감
		}
		
		// 90점 이상 A등급
		// 80점 이상 B등급
		// 70점 이상 C등급
		// 60점 이상 D등급
		// 60점 미만 F등급
		// 파트 2 : 학점 등급 매기는 부분
		String grade = "";//학점 등급
		if(score >= 90 && score <= 100) {
		grade = "A";
		System.out.println(grade);
		} else if (score >= 80 && score < 90) {
			grade = "B";
			System.out.println(grade);
		} else if (score >= 70 && score < 80) {
			grade = "C";
			System.out.println(grade);
		} else if (score >= 60 && score < 70) {
				grade = "D";
				System.out.println(grade);
		} else if (score >= 0 && score < 60 ){
				grade = "F";
				System.out.println(grade);
		} else {
			System.out.println("0과 100 사이의 값을 입력해주세요");
		}
		
		System.out.println("당신은" + grade + "학점입니다.");
	}

}
