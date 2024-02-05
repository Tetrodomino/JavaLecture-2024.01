package mysql.sec01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex01_Select {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/world", //호스트, 포트, DB명
					"hmuser", "hmpass"					 //사용자 이름, 패스워드
					);
			
			stmt = conn.createStatement();
			String sql = "select * from city where countrycode='KOR' limit 10"; //sql 코드
			
			// Select 실행
			ResultSet rs = stmt.executeQuery(sql); // 상기 sql 코드로 실행했을 때의 결과 데이터
			
			while (rs.next()) { // 데이터가 남아있을 경우 실행
				
				int id = rs.getInt(1); // 1번째 칼럼의 데이터를 int로 받음
									   // rs.getInt("ID")로도 가능
				
				String name = rs.getString(2); // 2번째 칼럼의 데이터를 String으로 받음
				String countryCode = rs.getString(3);
				String district = rs.getString(4);
				int population = rs.getInt(5);
				
				System.out.println(id + ", " + name + ", " + countryCode + ", " + district + ", " + population);
			}
			rs.close();
			stmt.close(); // 원칙적으론 finally 안에 또 try를 해야함
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
