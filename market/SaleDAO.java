package market;
import java.util.HashMap;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class SaleDAO {
	
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	List<SaleDTO> list;
	Boolean flag;
	ProductDAO pDao = new ProductDAO();
	ProductDTO pDto = new ProductDTO();
	
	
	public int insertSale(int sno, int sCnt) {
		sqlSession = sqlSessionFactory.openSession(true); 
		try {
			
			pDto = sqlSession.selectOne("selectSellPdt",sno);
			String sname = pDto.getPname(); 
			int tPrice = (pDto.getPrice() * sCnt); 
			HashMap<String, Object> map = new HashMap<>();
			map.put("sCnt", sCnt);
			map.put("sname", sname);
			map.put("tPrice", tPrice);
			
			result = sqlSession.insert("sale.insert",map);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	//일일 판매량 출력하는 함수
	public void dashBoard() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("sale.dashBoard");
			int i = 0;
			int cnt = 0;
			int price = 0;
			System.out.println("♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇");
			System.out.println(" 번호 \t 제품명 \t 판매수량 \t 가격");
			
			for(SaleDTO line : list) {
				System.out.print(" "+(i+1)+"\t");
				System.out.print(line.getSname() + "\t");
				System.out.print(line.getsCnt()+ "\t");
				System.out.print(line.getsPrice()+"\t");
				System.out.println();
				cnt += line.getsCnt();
				price += line.getsPrice();
				i += 1;
			}
			
				
			System.out.println("=========================================");
			System.out.println("♧◇ 오늘 판매한 제품은 총 " +list.size()+ " 종류로 총"+cnt+"개, 일일 총 판매액은"+price+"입니다.");
			System.out.println("♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇♧◇");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
}
