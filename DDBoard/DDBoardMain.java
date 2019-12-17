package problem.DDBoard;

import java.sql.Date;
import java.util.Scanner;

public class DDBoardMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardDAO bDao = new BoardDAO();
		
		while(true) {
			System.out.println("♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥");
			System.out.println("더블디 게시판");
			System.out.println("♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥");
			bDao.BoardSelect();
			System.out.println("♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥");
			System.out.println("♡♥♡♥1.게시글 등록");
			System.out.println("♡♥♡♥2.게시글 수정");
			System.out.println("♡♥♡♥3.게시글 삭제");
			System.out.println("♡♥♡♥4.게시글 조회");
			System.out.println("♡♥♡♥5.게시글 검색");
			System.out.println("♡♥♡♥6.게시글 정렬");
			System.out.println("♡♥♡♥7.상세 게시글");
			System.out.println("♡♥♡♥8.만든이");
			System.out.println("♡♥♡♥9.프로그램 종료");
			System.out.println("♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥");
			int code;
				while(true) {
			System.out.print("♡♥♡♥번호>>");
			code = sc.nextInt();
				if(code>=1 && code<=9) {
					break;
				} else {
					System.out.println("♡♥♡♥1~9 사이의 숫자를 입력해주세요");
					continue;
				}

			}
			
				if(code==1) {
					System.out.println("♡♥♡♥새 게시글을 등록합니다.");
					System.out.print("♡♥♡♥제목>>");
					sc.nextLine();
					String title = sc.nextLine();
					System.out.print("♡♥♡♥내용을 입력하세요>>");
					String content = sc.nextLine();
					System.out.print("♡♥♡♥작성자>>");
					String writer = sc.nextLine();
					BoardDTO bDto = new BoardDTO(title,content,writer);
					bDao.BoardInsert(bDto);
				}
				else if(code==2) {
					System.out.println("♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥");
					System.out.println("♡♥♡♥게시글을 수정하세요");
					System.out.print("♡♥♡♥수정할 게시글 번호>>");
					int bno = sc.nextInt();
					System.out.print("♡♥♡♥게시글 제목>>");
					sc.nextLine();
					String title = sc.nextLine();
					System.out.print("♡♥♡♥게시글 내용>>");
					String content = sc.nextLine();
					System.out.print("♡♥♡♥게시글 작성자>>");
					String writer = sc.nextLine();
					BoardDTO bDto = new BoardDTO(bno,title,content,writer);		
					bDao.BoardUpdate(bDto);
				}
				else if(code==3) {
					System.out.println("♡♥♡♥삭제하고싶은 게시글 번호를 입력해주세요");
					System.out.print("♡♥♡♥번호>>");
					int bno = sc.nextInt();
					bDao.BoardDelete(bno);
				}
				else if(code==4) {
					System.out.println("♡♥♡♥전체 게시글을 조회합니다.");
					bDao.BoardSelect();
				}
				else if(code==5) {
					System.out.print("♡♥♡♥게시글 제목 검색>>");
					sc.nextLine();
					String title = sc.nextLine();
					bDao.BoardSearch(title);
				}
				else if(code==6) {
					bDao.BoardView();
				}
				else if(code==7) {
					bDao.BoardSort();
				}
				else if(code==8) {
					System.out.println("♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥");
					System.out.println("♡♥♡♥ Name : DD Board Program");
					System.out.println("♡♥♡♥ Made by : HEY1");
					System.out.println("♡♥♡♥ Verion : 1.7");
					System.out.println("♡♥♡♥ Use : JAVA, ORACLE");
					System.out.println("♡♥♡♥ Date : 2019.12.17");
					System.out.println("♡♥♡♥ kwon5943@gmail.com");
				}
				else if(code==9) {
					System.out.println("♡♥프로그램 종료♡♥");
					System.exit(0);
				}
				
		}
		
		
		
		
		
		
	}

}
