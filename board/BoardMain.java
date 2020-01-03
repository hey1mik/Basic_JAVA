package board;

import java.util.Scanner;

public class BoardMain {
	
	static String session = "NO";
	static String userid = "";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardDAO bDao = new BoardDAO();
		MemberDAO mDao = new MemberDAO();
		
		
		while(true) {
			System.out.println("♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥");
			System.out.println("오리 게시판");
			System.out.println("login중인 아이디 >> "+userid);
			System.out.println("♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥");
			bDao.BoardSelect();
			System.out.println("♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥");
			System.out.println("♡♥♡♥0.로그인");
			System.out.println("♡♥♡♥1.게시글 등록");
			System.out.println("♡♥♡♥2.게시글 수정");
			System.out.println("♡♥♡♥3.게시글 삭제");
			System.out.println("♡♥♡♥4.게시글 조회");
			System.out.println("♡♥♡♥5.게시글 검색");
			System.out.println("♡♥♡♥6.게시글 정렬");
			System.out.println("♡♥♡♥7.상세 게시글");
			System.out.println("♡♥♡♥8.로그아웃");
			System.out.println("♡♥♡♥9.만든이");
			System.out.println("♡♥♡♥10.프로그램 종료");
			if(BoardMain.session.equals("YES")) {
				System.out.println("♡♥♡♥ "+BoardMain.userid+" 님 재방문을 환영합니다.");
			}
			System.out.println("♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥");
			int code;
				while(true) {
			System.out.print("♡♥♡♥번호>>");
			code = sc.nextInt();
				if(code>=0 && code<=9) {
					break;
				} else {
					System.out.println("♡♥♡♥1~9 사이의 숫자를 입력해주세요");
					continue;
				}

			}
				if(code==0) {
					System.out.println("♡♥♡♥로그인 화면입니다.");
					System.out.print("♡♥♡♥ID 입력>>");
					sc.nextLine();
					String id = sc.nextLine();
					System.out.print("♡♥♡♥비밀번호 입력>>");
					String pw = sc.nextLine();
					mDao.mLogin(id, pw);
				}
					
				else if(code==1) {
					if(BoardMain.session.equals("NO")) {
						System.out.println("♡♥♡♥ 로그인이 필요한 기능입니다.");
						continue;
					}
					
					System.out.println("♡♥♡♥새 게시글을 등록합니다.");
					System.out.print("♡♥♡♥제목>>");
					sc.nextLine();
					String title = sc.nextLine();
					System.out.print("♡♥♡♥내용을 입력하세요>>");
					String content = sc.nextLine();
					String writer = BoardMain.userid;
					bDao.BoardInsert(title, content, writer);
					
				}
				else if(code==2) {
					
					System.out.println("♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥");
					System.out.println("♡♥♡♥게시글을 수정하세요");
					System.out.print("♡♥♡♥수정할 게시글 번호>>");
					int bno = sc.nextInt();
					String writer = bDao.checkWriter(bno);
					
					if(writer.equals(userid)) {
						System.out.print("♡♥♡♥게시글 제목>>");
						sc.nextLine();
						String title = sc.nextLine();
						System.out.print("♡♥♡♥게시글 내용>>");
						String content = sc.nextLine();
						bDao.BoardUpdate(bno,title,content);
						
					} else {
						System.out.println("♡♥♡♥글 작성자만 수정할 수 있습니다.");
					}
					
				}
				else if(code==3) {
					System.out.println("♡♥♡♥삭제하고싶은 게시글 번호를 입력해주세요");
					System.out.print("♡♥♡♥번호>>");
					int bno = sc.nextInt();
					String writer = bDao.checkWriter(bno);
					if(writer.equals(userid)) { 
						bDao.BoardDelete(bno);
					} else {
						System.out.println("♡♥♡♥글 작성자만 삭제할 수 있습니다.");
					}
					
				}
				else if(code==4) {
					System.out.println("♡♥♡♥전체 게시글을 조회합니다.");
					bDao.BoardSelect();
				}
				else if(code==5) {
					System.out.print("♡♥♡♥게시글 제목+내용 검색>>");
					sc.nextLine();
					String keyword = sc.nextLine();
					bDao.BoardSearch(keyword);
				}
				else if(code==6) {
					System.out.println("♡♥♡♥게시글을 조회순으로 정렬합니다.");
					bDao.BoardSort();
				}
				else if(code==7) {
					System.out.print("♡♥♡♥보고싶은 게시글 번호>>");
					int bno = sc.nextInt();
					bDao.BoardView(bno);
				}
				else if(code==8) {
					System.out.println("♡♥♡♥로그아웃 화면입니다.");
					if(BoardMain.session.equals("YES")) { // 로그인
						System.out.println("♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥");
						System.out.println("♡♥♡♥" + BoardMain.userid+ "님 로그아웃 되었습니다.");
						BoardMain.session = "NO";
						BoardMain.userid = "";
					} else {
						System.out.println("♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥");
						System.out.println("♡♥♡♥ 로그인이 필요한 기능입니다.");
					}
				}
				else if(code==9) {
					System.out.println("♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥");
					System.out.println("♡♥♡♥ Name : DD Board Program");
					System.out.println("♡♥♡♥ Made by : HEY1");
					System.out.println("♡♥♡♥ Verion : 1.7");
					System.out.println("♡♥♡♥ Use : JAVA, ORACLE");
					System.out.println("♡♥♡♥ Date : 2019.12.17");
					System.out.println("♡♥♡♥ kwon5943@gmail.com");
				}
				else if(code==10) {
					System.out.println("♡♥프로그램 종료♡♥");
					System.exit(0);
				}
				
		}
		
		
		
		
		
		
	}

}