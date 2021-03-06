package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//createStatement() 방식
// : SQL문에 값을 하드코딩하여 직접 변경하지 않고는 수정 불가
// : => 그래서~ PreparedStatment 방식을 사용함

public class JdbcEx01 {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "java";
		String password = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("접속 성공!!");
			
			Statement st = conn.createStatement();
			String sql = "INSERT INTO tbl_study VALUES('5','미경',24)";
			
			int result = st.executeUpdate(sql);
			if(result > 0) {
				System.out.println("등록성공");
			}else {
				System.out.println("등록실패");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("고장났어요 죄송합니다...");
		} finally {
			
		}
		
	}
}
