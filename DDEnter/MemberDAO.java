package problem.DDEnter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ArrayList<MemberDTO> list = new ArrayList<>();
	
	//1. 아티스트 등록
	public void memInsert(MemberDTO mDto) {
		try {
			conn = DBManager.getConnection();
			String sql = " INSERT INTO tbl_enter(ano, aname, major, groupyn, sal) "
						+ " VALUES(seq_enter.NEXTVAL, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getAname());
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setInt(4, mDto.getSal());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("▽▲"+mDto.getAname()+"아티스트와 계약을 성사하였습니다.");
			} else {
				System.out.println("▽▲ 등록에 실패하였습니다. 관리자에게 문의해주세요.");
			}
			
		} catch (Exception e) {
			
		} finally {
			
		}
	}
	//2. 아티스트 수정
	public void memUpdate(MemberDTO mDto) {
		try {
			
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_enter "
						+"SET aname = ?, "
						+"major = ?, "
						+"groupyn = ?, "
						+"sal = ? "
						+"WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getAname());
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setInt(4, mDto.getSal());
			pstmt.setString(5, mDto.getAno());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("▽▲"+mDto.getAname()+"아티스트의 정보를 수정하였습니다.");
			}  else {
				System.out.println("▽▲ 수정에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5. close(연결끊기)
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	//3. 아티스트 삭제
	public void memDelete(String ano) {
		try {
				//1. 드라이버 로드
				//2. DB연결
				conn = DBManager.getConnection();
				//3. SQL문 작성(PrepareStatement 방식)
				String sql = "DELETE FROM tbl_enter "
						     +"WHERE ano = ?";
				pstmt = conn.prepareStatement(sql);
				//3.1 미완성 SQL문 완성(바인딩변수 사용)
				pstmt.setString(1, ano);
				//4. SQL문 실행!
				int result = pstmt.executeUpdate();
				
				if(result > 0) {
					System.out.println("▽▲"+ano+"아티스트와 계약을 해지하였습니다.");
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
	//4. 아티스트 조회
	public void memSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_enter";
			pstmt = conn.prepareStatement(sql);
			
			// 4.SQL실행 부분이 달라짐. execute쿼리를 씀! 데이터를 가져다 보여달라고 하는 거라서
			// ResultSet = SELECT문 결과를 담음
			// ResultSet은 DB임.
			
			// RestultSet은 DB전용, JAVA전용으로 바꿔주는 작업이 필요함.
			//JAVA전용 ArrayList에 ResultSet의 데이터를 옮겨 담는 작업이 필요하다.
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//rs.next()는 값이 있으면 true로 반환해서 
				//true면 반복문 한번 돌림
				//한row한row씩 true 를 판별해서 값을 반환
				// 몇 row가 있을지 모르기때문에 if가 아니라 while을 사용
				//따옴표에 있는 단어는 db에 있는 컬럼이랑 똑.같.이 써야함 
				// => 그래야 db에서 값을 가져올 수 있음
				String ano = rs.getString("ano");
				String aname = rs.getString("aname");
				String major = rs.getString("major");
				String groupyn = rs.getString("groupyn");
				int sal = rs.getInt("sal");
				Date regdate = rs.getDate("regdate");
				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, sal, regdate);
				list.add(mDto);
				
			}//for each  사용
	
			for (MemberDTO line : list) {

				System.out.println(line.toString());
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
		
		
		
		
	}
	//5. 아티스트 검색
	
	public void memSearch(String aname) {
			try {
			//1. 드라이버 등록, 2. Connection
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_enter "
						+"WHERE aname LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+aname+"%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String ano = rs.getString("ano");
				aname = rs.getString("aname");
				String major = rs.getString("major");
				String groupyn = rs.getString("groupyn");
				int sal = rs.getInt("sal");
				Date regdate = rs.getDate("regdate");
				System.out.println(aname);
				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, sal, regdate);
				list.add(mDto);
				
			}
			
			for (MemberDTO line : list) {

				System.out.println(line.toString());
			}
			
			} catch (Exception e) {
				
			} finally {
				
			}
		}
	}
	

