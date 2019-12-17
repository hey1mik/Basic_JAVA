package problem.DDBoard;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import problem.dotorybook.DBManager;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BoardDTO> list = new ArrayList<>();
	
		public void BoardInsert(BoardDTO bDto) {
			try {
				conn = DBManager.getConnection();
				String sql = " INSERT INTO tbl_board(bno, title, content, writer) "
							+" VALUES(seq_board.NEXTVAL, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bDto.getTitle());
				pstmt.setString(2, bDto.getContent());
				pstmt.setString(3, bDto.getWriter());
				
				int result = pstmt.executeUpdate();
				if(result > 0) {
					System.out.println("게시글 등록에 성공하였습니다.");
				} else {
					System.out.println("게시글 등록에 실패하였습니다. 관리자에게 문의해주세요");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public void BoardUpdate(BoardDTO bDto) {
			try {
				conn = DBManager.getConnection();
				String sql = "UPDATE tbl_board "
							+"SET title =?, "
							+"content = ?, "
							+"writer = ?"
							+"WHERE bno = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bDto.getTitle());
				pstmt.setString(2, bDto.getContent());
				pstmt.setString(3, bDto.getWriter());
				pstmt.setInt(4, bDto.getBno());
				
				int result = pstmt.executeUpdate();
				if(result > 0) {
					System.out.println("♡♥♡♥글 수정이 완료되었습니다.");
				} else {
					System.out.println("♡♥♡♥글 수정에 실패하였습니다. 관리자에게 문의해주세요.");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		public void BoardDelete(int bno) {
			try {
				conn = DBManager.getConnection();
				String sql = " DELETE FROM tbl_board "
							+" WHERE bno = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bno);
				
				int result = pstmt.executeUpdate();
				
				if(result>0) {
					System.out.println("♡♥♡♥게시글이 삭제되었습니다.");
				} else {
					System.out.println("♡♥♡♥게시글 삭제에 실패하였습니다. 관리자에게 문의해주세요");
				}
				
			} catch (Exception e) {
				
			}
		}
		public void BoardSelect() {
			try {
				conn = DBManager.getConnection();
				String sql = "SELECT * FROM tbl_board";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				list.clear();
				while(rs.next()) {
					int bno = rs.getInt("bno");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String writer = rs.getString("writer");
					Date regdate = rs.getDate("regdate");
					BoardDTO bDto = new BoardDTO(bno, title, content, writer, regdate);
					list.add(bDto);
				}
				
				for (BoardDTO line : list) {
					System.out.println(line.toString());
					System.out.println();
				}
			} catch (Exception e) {
				
			}
			
			
			
			
		}
		public void BoardSearch(String title) {
			try {
				conn = DBManager.getConnection();
				String sql = "SELECT * FROM tbl_board "
							+ "WHERE title like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+title+"%");
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int bno = rs.getInt("bno");
					title = rs.getString("title");
					String content = rs.getString("content");
					String writer = rs.getString("writer");
					Date regdate =  rs.getDate("regdate");
					BoardDTO bDto = new BoardDTO(bno, title, content, writer, regdate);
					list.add(bDto);
				}
				for (BoardDTO line : list) {
					System.out.println(line.toString());
					
				}
				
			} catch (Exception e) {
				
			}
			
		}
		public void BoardView() {
					
		}
		public void BoardSort() {
					
		}
	
}
