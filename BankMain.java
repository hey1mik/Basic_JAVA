package problem;

import java.util.Scanner;

public class BankMain {

		public static void main(String[] args) {
			BankDAO bDao = new BankDAO();
			while(true) {
				Scanner sc = new Scanner(System.in);
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣$$$$$오리네 은행$$$$$▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▣▣▣▣▣▣▣▣1. 계좌 개설");
				System.out.println("▣▣▣▣▣▣▣▣2. 입금");
				System.out.println("▣▣▣▣▣▣▣▣3. 출금");
				System.out.println("▣▣▣▣▣▣▣▣4. ??");
				System.out.println("▣▣▣▣▣▣▣▣5. 고객조회");
				System.out.println("▣▣▣▣▣▣▣▣6. 계좌조회");
				System.out.println("▣▣▣▣▣▣▣▣7. 계좌해지");
				System.out.println("▣▣▣▣▣▣▣▣8. 프로그램 종료");
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				int code = 0;
				while(true) {
					System.out.print("▣▣▣▣ 번호>>");
					code = sc.nextInt();
					if(code>=1 && code <=6) {
						break;
					} else {
						System.out.println("▣▣▣▣1 부터 6 사이의 숫자를 눌러주세요");
						continue;
					}
				}
				if(code==1){
					System.out.println("▣▣▣▣신규계좌를 개설합니다. 값을 입력해주세요");
					System.out.print("▣▣▣▣계좌명>>");
					sc.nextLine();
					String bname = sc.nextLine();
					System.out.print("▣▣▣▣계좌 암호>>");
					String pw = sc.nextLine();
					
					bDao.insertBank(bname,pw);
					
					
				}
				else if(code==2){
					System.out.println("▣▣▣▣입금 시스템 : 계좌번호를 입력해주세요");
					System.out.print("▣▣▣▣계좌번호>>");
					int bno = sc.nextInt();
					System.out.print("▣▣▣▣원하시는 금액을 입금해주세요>>");
					sc.nextLine();
					int money = sc.nextInt();
					
					bDao.updateBank(bno,money);
					
				}
				else if(code==3){
					System.out.println("▣▣▣▣출금 시스템: 계좌번호와 암호를 입력해주세요.");
					System.out.print("▣▣▣▣계좌번호>>");
					int bno = sc.nextInt();
					System.out.print("▣▣▣▣암호>>");
					sc.nextLine();
					String pw = sc.nextLine();
					boolean cu = bDao.checkUser(bno,pw);
					if(cu) {
						int balance = bDao.balanceMoney(bno);//잔액
						System.out.println("▣▣▣▣ 잔액>>"+balance);
						System.out.println("출금하실 금액을 입력해주세요");
						System.out.print("▣▣▣▣ 출금액>>");
						int money = sc.nextInt();
						if(balance < money) {
							System.out.println("▣▣▣▣ 잔액이 부족합니다. 확인해주세요");
						} else {
							bDao.minusMoney(bno, money);
							
						}
						
						
					} else {
						System.out.println("계좌번호가 존재하지 않거나 암호가 일치하지 않습니다.");
					}
				}
				else if(code==4){
				}
				else if(code==5){
					bDao.SelectBank();
				}
				else if(code==6) {//계좌조회(1건)
					//계좌번호, 패스워드 
					System.out.println("▣▣▣▣계좌를 조회합니다. 계좌번호와 암호를 입력해주세요.");
					System.out.print("▣▣▣▣계좌번호>>");
					int bno = sc.nextInt();
					System.out.print("▣▣▣▣암호>>");
					sc.nextLine();
					String pw = sc.nextLine();
					bDao.selectAccount(bno, pw);
				}
				else if(code==7){//계좌해지
					System.out.println("▣▣▣▣계좌를 해지합니다. 해지하고 싶은 계좌의 번호와 암호를 입력해주세요.");
					System.out.print("▣▣▣▣계좌번호>>");
					int bno = sc.nextInt();
					System.out.print("▣▣▣▣암호>>");
					sc.nextLine();
					String pw = sc.nextLine();
					bDao.deleteAccount(bno,pw);
				}
				else if(code==8){
					System.out.println("▣▣▣▣▣▣▣▣▣뱅크 시스템을 종료합니다.");
					System.exit(0);
				}
				
			}
		
			
		}
}
