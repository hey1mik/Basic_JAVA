package market;

import java.util.HashMap;
import java.util.Scanner;

public class MarketMain {

		String id = "admin";
		String pw = "1234";
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductDAO pDao = new ProductDAO();
		MarketMain mm = new MarketMain();
		int code = 0;
		Boolean flag = false;
		ProductDTO pDto = new ProductDTO();
		SaleDAO sDao = new SaleDAO();
		
		
		//내부 저장소
		//관리자계정 ID와 PW 선언. 포스기 로그인 하는걸로 생각하면 됨.
		
		String userid="";
		String userpw="";
		System.out.println("♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇");
		System.out.println("♧◇ GS25 MARKET SYSTEM VER 1.0 ");
		
//		do {
//			System.out.println("♧◇ [Msg] PLEASE LOGIN TO USE");
//		System.out.print("♧◇ ID >>");
//			userid = sc.nextLine();
//			System.out.print("♧◇ PW >>");
//			userpw = sc.nextLine();
//		} while(mm.login(userid, userpw));
		// 로그인 성공 업무 시작!
		while(true) {
			System.out.println("♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇");
			System.out.println("♧◇ 1. 제품 판매 ");
			System.out.println("♧◇ 2. 제품 등록 & 추가 ");
			System.out.println("♧◇ 3. 제품 수정 ");
			System.out.println("♧◇ 4. 제품 삭제 ");
			System.out.println("♧◇ 5. 제품 조회 ");
			System.out.println("♧◇ 6. 제품 검색 ");
			System.out.println("♧◇ 7. 일일 매출 현황 ");
			System.out.println("♧◇ 8. 프로그램 종료 ");
			
			while(true) {
				System.out.println("♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇");
				System.out.println("♧◇ 원하시는 기능을 선택해주세요.");
				System.out.print("♧◇ 번호 입력 >>");
				code = sc.nextInt();
				
				if(code>8 || code<1) {
					System.out.println("♧◇1~7 사이의 번호를 입력해주세요");
					continue;
					} else {
						break;
					}
				}
				
				if(code==1) {
					System.out.println("♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇");
					System.out.println("♧◇ 제품을 판매합니다.");
					System.out.print("♧◇ 제품명 검색>>");
					sc.nextLine();
					String keyword = sc.nextLine();
					pDao.searchPdt(keyword);
					while(true) {
						System.out.print("♧◇ 판매하고자 하는 제품 번호>>");
						int sno = sc.nextInt();
						System.out.print("♧◇ 수량 >>");
						int sCnt = sc.nextInt();
						boolean check = pDao.checkPdt(sno, sCnt);
						if(check) {
							pDao.selectSellPdt(sno, sCnt);
							int result = sDao.insertSale(sno, sCnt);
							if(result > 0) {
								pDao.cntMinusPdt(sno, sCnt);
								System.out.println("♧◇ 판매성공하였습니다.");
							} else {
								System.out.println("♧◇ 매출 리스트 업데이트에 실패하였습니다.");
							}
							break;
							//tbl_sale에 판매한 기록을 저장
							// 판매하는 제품명, 수량, 총가격
						} else {
							System.out.println("♧◇ 판매할 상품이 존재하지 않거나 수량이 부족합니다.");
							continue;
						}
					}
				
					
				} else if(code == 2) {
					System.out.println("♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇");
					System.out.println("♧◇ 제품의 이름을 입력하세요");
					System.out.print("♧◇ 제품명 >>");
					sc.nextLine();
					String pname = sc.nextLine();
					
					if(pDao.pdtAlready(pname)) {
						// 기존에 등록된 제품임으로 추가(UPDATE) 기능
						// 입고수량 입력받아서 UPDATE
						System.out.println("♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇");
						System.out.println("♧◇ " +pname + " 제품을 추가 입고합니다.");
						System.out.print("♧◇ 추가입고 수량 입력>>");
						int cnt = sc.nextInt();
						pDao.cntPlusPdt(cnt, pname);
					} else {
						// 최초 등록된 제품임으로 등록(INSERT) 기능
						// company, price, cnt 입력받아서 INSERT
						System.out.println("♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇");
						System.out.println("♧◇ 새 제품 " + pname + "을(를) 입고합니다.");
						System.out.print("♧◇ 제품 회사명 입력>>");
						String company = sc.nextLine();
						System.out.print("♧◇ 제품 가격 입력>>");
						int price = sc.nextInt();
						System.out.print("♧◇ 제품 수량 입력>>");
						int cnt = sc.nextInt(); 
						pDto = new ProductDTO(pname,company,price,cnt);
						pDao.insertPdt(pDto);
					}
					
					
				} else if(code == 3) {
					System.out.println("♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇");
					System.out.println("♧◇ 제품정보를 수정합니다.");
					while(true) {
						System.out.print("♧◇ 수정하실 제품명>>");
						sc.nextLine();
						String pname = sc.nextLine();
						if(pDao.pdtAlready(pname)) {
							System.out.print("♧◇ 수정 후 제품이름>>");
							String newPname = sc.nextLine();
							System.out.print("♧◇ 제품 회사명 입력>>");
							String company = sc.nextLine();
							System.out.print("♧◇ 제품 가격 입력>>");
							int price = sc.nextInt();
							pDto = new ProductDTO(pname, company, price, newPname);
							pDao.updatePdt(pDto);
							break;
						} else {
							System.out.println("♧◇ 수정하실 제품이 존재하지 않습니다.");
							continue;
						}
					}
					
					
					
				} else if(code == 4) {
					System.out.println("♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇");
					System.out.println("♧◇ 삭제하실 제품의 이름을 입력해주세요.");
					while(true) {
						System.out.print("♧◇ 제품명 >>");
						sc.nextLine();
						String pname = sc.nextLine();
						if(pDao.pdtAlready(pname)) {
						pDao.deletPdt(pname);	
							break;
						} else {
							System.out.println("♧◇ 삭제하실 제품이 존재하지 않습니다.");
							continue;
						}
					}
					
				} else if(code == 5) {
					System.out.println("♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇");
					System.out.println("♧◇ 현재 진열되어있는 상품 list를 조회합니다.");
					pDao.selectPdt();
					System.out.println("♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇");
				} else if(code == 6) {
					System.out.println("♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇");
					System.out.println("♧◇ 제품을 검색합니다.");
					System.out.print("♧◇ 검색어>>");
					sc.nextLine();
					String keyword = sc.nextLine();
					pDao.searchPdt(keyword);
					
				} else if(code == 7) {
					System.out.println("♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇");
					sDao.dashBoard();
				} else if(code == 8) {
					System.out.println("♧◇ [Msg] Exit the program.");
					System.exit(0);
				}
			}
				
		}
			
	
		
		


	 
	
	
	
	public boolean login(String userid, String userpw) {
		 Boolean flag = true; // 로그인 유무 판별 (true : 실패, false : 성공)
		 
		 if(userid.equals(id) && userpw.equals(pw)) { //로그인 성공!
			 flag = false;
			 System.out.println("♧◇ 환영합니다 관리자님");
		 } else {
			 System.out.println("♧◇ [Msg] Login denied.");
		 }
		 		 
		 return flag;
	}
}
