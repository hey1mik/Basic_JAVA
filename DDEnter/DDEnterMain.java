package problem.DDEnter;

import java.util.Scanner;

public class DDEnterMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int code;
			while(true) {
				System.out.println("▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲");
				System.out.println("▽▲▽▲더블디 엔터 관리 시스템");
				System.out.println("▽▲▽▲1. 아티스트 등록");
				System.out.println("▽▲▽▲2. 아티스트 수정");
				System.out.println("▽▲▽▲3. 아티스트 해지");
				System.out.println("▽▲▽▲4. 아티스트 조회");
				System.out.println("▽▲▽▲5. 아티스트 검색");
				System.out.println("▽▲▽▲6. 프로그램 종료");
				System.out.println("▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲");
				System.out.println("번호>>");
				code = sc.nextInt();
				//사용자가 1~6까지 입력하기 전까지 계속 번호를 입력하게 도는 반복문
				if(code>6||code<1) {
					System.out.println("1~6 사이의 번호를 입력해주세요");
					continue;
				} else {
					break;
					}
				
				}
				MemberDAO mDao = new MemberDAO();
				// 사용자가 입력한 값 1~6인 경우
				if(code == 1) { //아티스트 등록
					System.out.println("▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲");
					System.out.println("▽▲▽▲계약할 아티스트 정보를 입력해주세요");
					System.out.print("▽▲▽▲이름>>");
					sc.nextLine();
					String aname = sc.nextLine();
					System.out.print("▽▲▽▲분야>>");
					String major = sc.nextLine();
					System.out.print("▽▲▽▲그룹유무>>");
					String groupyn = sc.nextLine();
					System.out.print("▽▲▽▲연봉>>");
					int sal = sc.nextInt();
					MemberDTO mDto = new MemberDTO(aname, major, groupyn, sal);
					mDao.memInsert(mDto);
					
				} else if (code == 2) { 
					System.out.println("▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲");
					System.out.println("▽▲▽▲수정할 아티스트 번호를 입력해주세요");
					System.out.print("▽▲▽▲번호>>");
					sc.nextLine();
					String ano = sc.nextLine();
					System.out.print("▽▲▽▲이름>>");
					String aname = sc.nextLine();
					System.out.print("▽▲▽▲분야>>");
					String major = sc.nextLine();
					System.out.print("▽▲▽▲그룹유무>>");
					String groupyn = sc.nextLine();
					System.out.print("▽▲▽▲연봉>>");
					int sal = sc.nextInt();
					MemberDTO mDto = new MemberDTO(ano,aname,major,groupyn,sal);
					mDao.memUpdate(mDto);
					
				
				} else if (code == 3) { // 아티스트 삭제 메서드
					System.out.println("▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲");
					System.out.println("▽▲▽▲삭제할 아티스트 번호를 입력해주세요");
					System.out.println("▽▲▽▲번호>>");
					sc.nextLine();
					String ano = sc.nextLine();
					mDao.memDelete(ano);
				} else if (code == 4) { // 아티스트 조회 메서드
					
					mDao.memSelect();
				} else if (code == 5) {
					System.out.println("▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲▽▲");
					System.out.println("▽▲▽▲검색할 아티스트의 이름을 입력해주세요");
					System.out.print("▽▲▽▲이름>>");
					sc.nextLine();
					String aname = sc.nextLine();
					mDao.memSearch(aname);
				} else if (code == 6) {
					System.out.println("<프로그램 종료>");
					System.exit(0); // 프로그램을 종료하는 코드
					// 0 -> 즉시종료
					// 1- > 재부팅
				}
		}
		

		
	}		
		
}

