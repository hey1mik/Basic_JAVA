package shop;

import java.util.Scanner;

public class ShopMain {

	public static void main(String[] args) {
		/*
		 * 사용자에게 값을 입력(회원관련 기능 구현) 1. 회원가입 2. 회원수정 3. 회원탈퇴
		 */
		// 객체 생성 (사용자 키보드값을 받기 위함)
		Scanner sc = new Scanner(System.in);

		System.out.println("=================================");
		System.out.println("====shooooooop ver 1.5");
		System.out.println("====1. 회원가입");
		System.out.println("====2. 회원수정");
		System.out.println("====3. 회원탈퇴");

		int num;

		while (true) {
			System.out.print("====번호>>");
			num = sc.nextInt();

			/*
			 * 1,2,3 이외의 값이 들어온 경우 Error 발생 및 다시 번호를 입력받음 1,2,3이 들어온 경우 while() 문을 break
			 */
			if (num < 1 || num > 3) {
				System.out.println("== Error >> 1,2,3 중 하나의 값을 입력하세요");
				continue; // 다시 값을 입력받게 하는 역할
			} else {
				break;
			}
		}

		// ==>사용자가 입력한 값은 1,2,3 중에 하나인 상태

		Member mem = new Member();

		if (num == 1) { // 회원가입
			String id = "slong0204";
			String pw = "1234";
			String name = "혜원";
			String result = mem.memInsert(id, pw, name);
			if (result.equals("success")) {
				System.out.println("회원가입 성공! 메인 페이지로 이동합니다.");
			} else {
				System.out.println("회원가입 실패! 에러 메시지 출력");
			}

		} else if (num == 2) { // 회원수정
			mem.memUpdate();
		} else if (num == 3) { // 회원탈퇴
			String id = "slong0204";
			String pw = "1234";
			mem.memDelete(id, pw);

		}
		sc.close();
	}
}
