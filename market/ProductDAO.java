package market;

import java.util.HashMap;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ProductDAO {

	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	List<ProductDTO> list;
	ProductDTO pDto = new ProductDTO();
	Boolean flag; // default값 false
	// 제품 등록 & 추가 기능 작동시 기존에 등록된 제품인지 최초입고제품인지 판별하는 기능
	
	//기존 제품 판별
	public boolean pdtAlready(String pname) {

		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.selectOne("pdt.already", pname);
			if(result > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//제품 재입고
	public void cntPlusPdt(int cnt, String pname) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, Object> map = new HashMap<>();
			map.put("cnt", cnt);
			map.put("pname", pname);
			map.put("flag", "plus");
			result = sqlSession.update("pdt.cntchange",map);
			if(result>0) {
				System.out.println("♧◇ 제품 재입고를 완료하였습니다.");
			} else {
				System.out.println("♧◇ 제품 재입고에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	//새 제품 등록
	public void insertPdt(ProductDTO pDto) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.insert("pdt.insert",pDto);
			if(result>0) {
				System.out.println("♧◇ 세 제품 등록을 완료하였습니다.");
			} else {
				System.out.println("♧◇ 제품 등록에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	
	//제품 조회
	public void selectPdt() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("pdt.select");
			for(ProductDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//제품 삭제
	public void deletPdt(String pname) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.update("pdt.delete",pname);
			if(result>0) {
				System.out.println("♧◇제품을 목록에서 삭제하였습니다.");
			} else {
				System.out.println("♧◇제품 삭제에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//제품 수정
	public void updatePdt(ProductDTO pDto) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.insert("pdt.update",pDto);
			if(result>0) {
				System.out.println("♧◇ 제품 정보 수정을 완료하였습니다.");
			} else {
				System.out.println("♧◇ 제품 정보 수정에 실패하였습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	//제품 검색
	public void searchPdt(String keyword) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("pdt.search",keyword);
			for(ProductDTO line : list) {
				System.out.println(line.toString());
			}
		if(list.isEmpty()){
			System.out.println("♧◇ "+keyword+" (으)로 검색되는 상품이 존재하지 않습니다.");
			return;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//판매물품 & 재고 비교
	public boolean checkPdt(int sno, int sCnt) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			HashMap<String,Integer> map = new HashMap<>();
			map.put("pno", sno);
			map.put("cnt", sCnt);
			list = sqlSession.selectList("pdt.check",map);
			if(list.isEmpty()) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public void selectSellPdt(int sno, int sCnt) {
		sqlSession = sqlSessionFactory.openSession(true); 
		try {
		
			pDto = sqlSession.selectOne("selectSellPdt",sno);
			int tPrice = (pDto.getPrice() * sCnt); 
			System.out.println("♧◇ 판매하고자 하는 물건, 구매수량과 총 가격 입니다.");
			System.out.println(pDto.getPno() + "\t" + pDto.getPname() + "\t" + sCnt + "\t" +tPrice);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void cntMinusPdt(int sno, int sCnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, Integer> map = new HashMap<>();
			map.put("sno", sno);
			map.put("sCnt", sCnt);
			result = sqlSession.update("pdt.cntminus",map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
