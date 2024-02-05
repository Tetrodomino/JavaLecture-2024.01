package mysql.sec01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex02_SelectParameter {

	public static void main(String[] args) {

		select("USA", 10);
		
	}
	
	static void select(String countryCode, int num) {
		
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/world",
					"hmuser", "hmpass"
					);
			
			// sql 파라메터의 값이 초기에 정해지지 않으면 ? 로 작성
			String sql = "select * from city where countrycode=? limit ?";
			
			// 파라메터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, countryCode); // 첫 번째 ? 에 데이터 대입
			pstmt.setInt(2, num); // 2번째 ?에 데이터 대입
			
			// Select 실행 후 결과를 ResultSet에 받기
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) { // 데이터가 남아있을 경우 실행 (로우row 마다 실행)
				
				int id = rs.getInt(1); // 1번째 칼럼의 데이터를 int로 받음
									   // rs.getInt("ID")로도 가능
				
				String name = rs.getString(2); // 2번째 칼럼의 데이터를 String으로 받음
				String countrycode = rs.getString(3);
				String district = rs.getString(4);
				int population = rs.getInt(5);
				
				System.out.println(id + ", " + name + ", " + countrycode + ", " + district + ", " + population);
			}

			rs.close();
			pstmt.close(); // 원칙적으론 finally 안에 또 try를 해야함
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
