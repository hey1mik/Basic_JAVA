  
package board;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardDAO bDao = new BoardDAO();
		BoardDTO bDto = new BoardDTO();
		
		while(true) {
			System.out.println("����������������������������������������������������������������������������");
			System.out.println("���� �Խ���");
			System.out.println("����������������������������������������������������������������������������");
			bDao.BoardSelect();
			System.out.println("����������������������������������������������������������������������������");
			System.out.println("��������1.�Խñ� ���");
			System.out.println("��������2.�Խñ� ����");
			System.out.println("��������3.�Խñ� ����");
			System.out.println("��������4.�Խñ� ��ȸ");
			System.out.println("��������5.�Խñ� �˻�");
			System.out.println("��������6.�Խñ� ����");
			System.out.println("��������7.�� �Խñ�");
			System.out.println("��������8.������");
			System.out.println("��������9.���α׷� ����");
			System.out.println("����������������������������������������������������������������������������");
			int code;
				while(true) {
			System.out.print("����������ȣ>>");
			code = sc.nextInt();
				if(code>=1 && code<=9) {
					break;
				} else {
					System.out.println("��������1~9 ������ ���ڸ� �Է����ּ���");
					continue;
				}

			}
			
				if(code==1) {
					System.out.println("���������� �Խñ��� ����մϴ�.");
					System.out.print("������������>>");
					sc.nextLine();
					String title = sc.nextLine();
					System.out.print("�������������� �Է��ϼ���>>");
					String content = sc.nextLine();
					System.out.print("���������ۼ���>>");
					String writer = sc.nextLine();
					
				}
				else if(code==2) {
					System.out.println("����������������������������������������������������������������������������");
					System.out.println("���������Խñ��� �����ϼ���");
					System.out.print("�������������� �Խñ� ��ȣ>>");
					int bno = sc.nextInt();
					System.out.print("���������Խñ� ����>>");
					sc.nextLine();
					String title = sc.nextLine();
					System.out.print("���������Խñ� ����>>");
					String content = sc.nextLine();
					System.out.print("���������Խñ� �ۼ���>>");
					String writer = sc.nextLine();
					
				}
				else if(code==3) {
					System.out.println("�������������ϰ���� �Խñ� ��ȣ�� �Է����ּ���");
					System.out.print("����������ȣ>>");
					int bno = sc.nextInt();
				
				}
				else if(code==4) {
					System.out.println("����������ü �Խñ��� ��ȸ�մϴ�.");
					bDao.BoardSelect();
				}
				else if(code==5) {
					System.out.print("���������Խñ� ���� �˻�>>");
					sc.nextLine();
					String title = sc.nextLine();
					bDao.BoardSearch(title);
				}
				else if(code==6) {
					
				}
				else if(code==7) {
					System.out.print("��������������� �Խñ� ��ȣ>>");
					int bno = sc.nextInt();
					bDao.BoardView(bno);
				}
				else if(code==8) {
					System.out.println("����������������������������������������������������������������������������");
					System.out.println("�������� Name : DD Board Program");
					System.out.println("�������� Made by : HEY1");
					System.out.println("�������� Verion : 1.7");
					System.out.println("�������� Use : JAVA, ORACLE");
					System.out.println("�������� Date : 2019.12.17");
					System.out.println("�������� kwon5943@gmail.com");
				}
				else if(code==9) {
					System.out.println("�������α׷� ���ᢽ��");
					System.exit(0);
				}
				
		}
		
		
		
		
		
		
	}

}