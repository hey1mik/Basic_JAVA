package problem;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BankDAO {
	

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
		
			if(list == null) {
				System.out.println("▣▣▣▣존재하지 않는 계좌번호이거나 암호가 일치하지 않습니다.");
				return;
			} else {
				System.out.println("▣▣▣▣계좌번호 "+bno+"의 잔액은 "+balanceMoney(bno)+"원 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	
	public void updateBank(int bno, int money) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String,Integer> map = new HashMap<>();
			map.put("bno",bno);
			map.put("money",money);
			map.put("flag", 1);
			result = sqlSession.update("changeMoney",map);
			if(result>0) {
				System.out.println("▣▣▣▣" + bno + "계좌에 입금 성공하였습니다.");
				System.out.println("▣▣▣▣ 현재 계좌 잔액은" + balanceMoney(bno) + "입니다.");
			} else {
				System.out.println("▣▣▣▣입금에 실패하였습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	
	public void deleteAccount(int bno, String pw) {
		sqlSession = sqlSessionFactory.openSession(true);
		//Hashmap은 key랑 value로 값을 꺼낸다!
		//"bno", bno
		//"pw", pw
		HashMap<String, Object> map = new HashMap<>(); 
		map.put("bno", bno);
		map.put("pw", pw);				
		try {
			result = sqlSession.delete("deleteAccount", map);
			if(result>0) {
				System.out.println("▣▣▣▣"+bno+"계좌를 해지하였습니다.");
			
			}else {
				System.out.println("▣▣▣▣ 계좌해지에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	//계좌잔액조회
	public int balanceMoney(int bno) {
		sqlSession = sqlSessionFactory.openSession();
		int money = 0;
		try {
			money = sqlSession.selectOne("balanceMoney", bno);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sqlSession.close();
		}
		return money;
	}
	
	public boolean checkUser(int bno, String pw) {
		boolean flag = false;
		sqlSession = sqlSessionFactory.openSession();
		HashMap<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("pw", pw);
		try {
			result = sqlSession.selectOne("checkUser",map);
			if (result > 0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sqlSession.close();
		
		}
		return flag;
	}
	
	public void minusMoney(int bno, int money) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("bno", bno);
		map.put("money", money);
		map.put("flag", 0);
		
		try {
			result = sqlSession.update("changeMoney", map);
			if (result>0) {
				System.out.println("▣▣▣▣ 출금되었습니다.");
				System.out.println("▣▣▣▣ 현재 계좌 잔액은" + balanceMoney(bno) + "입니다.");
			} else {
				System.out.println("▣▣▣▣ 출금실패. 관리자에게 문의해주세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
