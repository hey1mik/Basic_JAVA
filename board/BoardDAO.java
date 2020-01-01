package board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;
public class BoardDAO {

	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	List<BoardDTO> list;
	BoardDTO bDto;
	int result;
	
		public void BoardInsert(){}
		public void BoardUpdate(){}
		public void BoardDelete(){}
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
		public void BoardSearch(String title) {
			try {
				sqlSession = sqlSessionFactory.openSession();
				list = sqlSession.selectList("BoardSearch",title);
				for(BoardDTO line : list) {
					System.out.println(line.toString());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void BoardView(int bno) {
			sqlSession = sqlSessionFactory.openSession(true);
			try {
				result = sqlSession.update("plusViewcnt", bno);
				if(result>0) {
					bDto = sqlSession.selectOne("BoardView",bno);
					System.out.println(bDto.toString());
				} else {
					System.out.println("게시글 조회에 실패하였습니다.");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		public void BoardSort() {}
	
}