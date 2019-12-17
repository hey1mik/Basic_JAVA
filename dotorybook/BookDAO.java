package problem.dotorybook;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import problem.DDEnter.DBManager;

public class BookDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BookDTO> list = new ArrayList<>();
	
	public void bookInsert(BookDTO bDto){
		try {
			conn = DBManager.getConnection();
			String sql = " INSERT INTO tbl_book(bno, bname, price, company, writer) "
						+ " VALUES(seq_enter.NEXTVAL, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setInt(2, bDto.getPrice());
			pstmt.setString(3, bDto.getCompany());
			pstmt.setString(4, bDto.getWriter());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("▽▲"+bDto.getBname()+"를 등록했습니다.");
			} else {
				System.out.println("▽▲ 등록에 실패하였습니다. 관리자에게 문의해주세요.");
			}
			
		} catch (Exception e) {
			
		} finally {
			
		}
		
	
	}
	public void bookUpdate(BookDTO bDto){
		
		try {
		
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_book "
						+"SET bname = ?, "
						+"price = ?, "
						+"company = ?, "
						+"writer = ? "
						+"WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setInt(2, bDto.getPrice());
			pstmt.setString(3, bDto.getCompany());
			pstmt.setString(4, bDto.getWriter());
			pstmt.setString(5, bDto.getBno());

			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("▽▲"+bDto.getBname()+"책의 정보를 수정하였습니다.");
			}  else {
				System.out.println("▽▲ 수정에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void bookDelete(String bno){
		try {
			//1. 드라이버 로드
			//2. DB연결
			conn = DBManager.getConnection();
			//3. SQL문 작성(PrepareStatement 방식)
			String sql = "DELETE FROM tbl_book "
					     +"WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			//3.1 미완성 SQL문 완성(바인딩변수 사용)
			pstmt.setString(1, bno);
			//4. SQL문 실행!
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("▽▲"+bno+"번 책을 목록에서 삭제하였습니다.");
			} else {
				System.out.println("▽▲ 삭제에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
			}
			
		}
	}
	public void bookSelect(){
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bno = rs.getString("bno");
				String bname = rs.getString("bname");
				int price = rs.getInt("price");
				String company = rs.getString("company");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				BookDTO bDto = new BookDTO(bno, bname, price, company, writer, regdate);
				list.add(bDto);
			}
			for (BookDTO line : list) {
				System.out.print(line.getBno() + "\t");
				System.out.print(line.getBname() + "\t");
				System.out.print(line.getPrice() + "\t");
				System.out.print(line.getCompany() + "\t");
				System.out.print(line.getWriter() + "\t");
				System.out.print(line.getRegdate() + "\t");
				System.out.println();
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
	}
	public void bookSearch(String bname){
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_book "
						+"WHERE bname LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+bname+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bno = rs.getString("bno");
				bname = rs.getString("bname");
				int price = rs.getInt("price");
				String company = rs.getString("company");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				BookDTO bDto = new BookDTO(bno, bname, price, company, writer, regdate);
				list.add(bDto);
			}
			for (BookDTO line : list) {
				System.out.print(line.toString());
				System.out.println();
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
	}
	public void madeBy(){
		
		System.out.println("혜원이가 만듦!");
		
	}
	
}
