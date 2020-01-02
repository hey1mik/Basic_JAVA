package board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;
public class BoardDAO {

	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	List<BoardDTO> list;
	MemberDTO mDto;
	BoardDTO bDto;
	int result;
	
		public void BoardInsert(String title, String content, String writer){
			sqlSession = sqlSessionFactory.openSession(true);
			try {
				HashMap<String, String> map = new HashMap<>();
				map.put("title", title);
				map.put("content", content);
				map.put("writer", writer);
				result = sqlSession.insert("BoardInsert",map);
				if(result>0) {
					System.out.println("♡♥♡♥게시글이 등록되었습니다.");
				} else {
					System.out.println("♡♥♡♥게시글 등록에 실패하였습니다. 관리자에게 문의해주세요");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void BoardUpdate(int bno, String title, String content){
			sqlSession = sqlSessionFactory.openSession(true);
			try {
				HashMap<String, Object> map = new HashMap<>();
				map.put("bno", bno);
				map.put("title",title);
				map.put("content",content);
				
				result = sqlSession.update("BoardUpdate",map);
				
				if(result>0) {
					System.out.println("♡♥♡♥게시글 수정을 완료하였습니다.");
				} else {
					System.out.println("♡♥♡♥게시글 수정에 실패하였습니다. 관리자에게 문의해주세요.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
		}
		public void BoardDelete(int bno){
			sqlSession = sqlSessionFactory.openSession(true);
			try {
				
				result = sqlSession.delete("BoardDelete", bno);
				if(result>0) {
					System.out.println("♡♥♡♥게시글이 삭제되었습니다.");
				} else {
					System.out.println("♡♥♡♥게시글 삭제에 실패하였습니다. 관리자에게 문의해주세요.");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
		public void BoardSearch(String keyword) {
			try {
				sqlSession = sqlSessionFactory.openSession();
				HashMap<String, String> map = new HashMap<>();
				map.put("keyword", "%"+keyword+"%");
				list = sqlSession.selectList("BoardSearch",map);
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
		public void BoardSort() {
			sqlSession = sqlSessionFactory.openSession();
			try {
				list = sqlSession.selectList("BoardSort");
				for(BoardDTO line : list) {
					System.out.println(line.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public String checkWriter(int bno) {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectOne("checkWriter",bno);
		}
	
		
}