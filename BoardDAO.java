package board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDAO {
	
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	List<BoardDTO> list;
	BoardDTO bDto;

	public void BoardSelect(){
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("selBoard");
			for(BoardDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	
	}
	public void BoardInsert(String title, String content, String writer){
		
	}
	public void BoardUpdate(int bno, String title, String content, String writer){
		
	}
	public void BoardDelete(){
		
	}
	public void BoardSearch(){
		
	}
	public void BoardView(){
		
	}
	public void BoardSort(){
		
	}
	
	
}
