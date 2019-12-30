package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BankDAO {
	
	Connection conn;
	ResultSet rs;
	PreparedStatement pstmt;
	BankDTO dto;
	

	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	
	SqlSession sqlSession;
	
	List<BankDTO> list;
	int result;

		//신규계좌 개설
	public void insertBank(String bname, String pw) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		try {
			BankDTO bDto = new BankDTO(bname, pw);
			result = sqlSession.insert("insertBank", bDto);
			if(result>0) {
				System.out.println("▣▣▣▣" + bname + "님 신규계좌를 개설하였습니다.");
			} else {
				System.out.println("▣▣▣▣계좌개설에 실패하였습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void SelectBank() {
		sqlSession = sqlSessionFactory.openSession();
		
		try {
			list = sqlSession.selectList("selBank");//selectList는 조회건이 여러건일때, 조회건이 한건일때는 selectOne을 쓴다.
			for(BankDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	
	public void selectAccount(int bno, String pw) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			BankDTO bDto = new BankDTO(bno, pw);
			bDto = sqlSession.selectOne("selectAccount", bDto);
			//SelectOne => DTO
			//SelectList => LIST or DTO
		
			if(bDto == null) {
				System.out.println("▣▣▣▣존재하지 않는 계좌번호이거나 암호가 일치하지 않습니다.");
				return;
			} else {
				System.out.println("▣▣▣▣계좌번호 "+bno+"의 잔액은 "+bDto.getMoney()+"원 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	
	public void updateBank(int bno, String money) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String,Object> map = new HashMap<>();
			map.put("bno",bno);
			map.put("money",money);
			result = sqlSession.update("updateBank",map);
			if(result>0) {
				System.out.println("▣▣▣▣" + bno + "계좌에 입금 성공하였습니다.");
			} else {
				System.out.println("▣▣▣▣입금에 실패하였습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	
	public int conf(int bno, String pw) {
		int conf = 0;
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_bank "
						+ "WHERE bno =? AND pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				conf = 1;
			} else {
				conf = 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conf;
	}
	
}
