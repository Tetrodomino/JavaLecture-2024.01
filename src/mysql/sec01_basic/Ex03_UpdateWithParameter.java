package mysql.sec01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex03_UpdateWithParameter {

	public static void main(String[] args) {

		// 데이터 수정
		// country 파일의 'suwon' 도시의 인구를 120만으로 바꾸고 이름도 '수원'으로 바꾸기
		update(2340, "수원", 1200000);
	}

	static void update(int id, String name, int population) {
		
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/world",
					"hmuser", "hmpass"
					);
			
			String sql = "update city set name=?, population=? where id=?";
			
			// 파라메터 설정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name); // 1번째 물음표에 name 대입
			pstmt.setInt(2, population);
			pstmt.setInt(3, id);
			
			// UPDATE 실행 - 반환값이 없는 쿼리 
			// INSERT, DELETE도 반환값 없음
			pstmt.executeUpdate(); // ResultSet에 대입할 필요 없음 
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
