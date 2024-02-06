package mysql.sec04_girl_group;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GirlGroupDao {

	private String connStr;
	private String user;
	private String password;
	private Connection conn;
	
	public GirlGroupDao() {
		String path = "C:/Workspace/Java/lesson/src/mysql/mysql.properties";
		
		// mysql.properties 파일에서 데이터를 받아오기
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(path));
			
			// host, port, database 등을 받기
			String host = prop.getProperty("host");
			String port = prop.getProperty("port");
			String database = prop.getProperty("database");
			
			// user, password 등을 받아오기
			this.user = prop.getProperty("user");
			this.password = prop.getProperty("password");
			this.connStr = "jdbc:mysql://" + host + ":" + port + "/" + database;
			this.conn = DriverManager.getConnection(connStr, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public GirlGroup getGirlGroupByGid(int gid) {
		String sql = "select * from girl_group where gid=?";
		GirlGroup gg = new GirlGroup();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, gid);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				gg.setGid(rs.getInt(1));
				gg.setName(rs.getString(2));
				
				// debut 값(LocalDate)을 부르기
				String debutStr = rs.getString(3);
				gg.setDebut(LocalDate.parse(debutStr)); // parse 메소드 사용
				
				gg.setHit_song_id(rs.getInt(4));
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return gg;
	}
	
	public GirlGroup getGirlGroupByName(String name) {
		String sql = "SELECT l.gid, l.name, l.debut, r.title FROM girl_group l"
					+ "	JOIN song r ON l.hit_song_id=r.sid"
					+ "	WHERE l.name LIKE ?";
		
		GirlGroup gg = new GirlGroup();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + name + "%");
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				gg.setGid(rs.getInt(1));
				gg.setName(rs.getString(2));
				
				// debut 값(LocalDate)을 부르기
				String debutStr = rs.getString(3);
				gg.setDebut(LocalDate.parse(debutStr)); // parse 메소드 사용
				
				gg.setHit_song_title(rs.getString(4));
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return gg;
	}
	
	public List<GirlGroup> getGirlGroupByDebut(int fromYear, int toYear) {
		
		String sql = "SELECT l.gid, l.name, l.debut, r.title FROM girl_group l"
				+ "	JOIN song r ON l.hit_song_id=r.sid"
				+ "	WHERE l.debut BETWEEN ? AND ?"
				+ " ORDER BY l.debut";
		
		List<GirlGroup> list = new ArrayList<GirlGroup>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fromYear + "-01-01");
			pstmt.setString(2, toYear + "-12-31");
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				GirlGroup gg = new GirlGroup(rs.getInt(1), rs.getString(2)
						, LocalDate.parse(rs.getString(3)), 0, rs.getString(4));
				
				list.add(gg);
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void insertGirlGroup(GirlGroup gg) {
		String sql = "insert into girl_group values(default, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gg.getName());
			pstmt.setString(2, gg.getDebut().toString());
			pstmt.setInt(3, gg.getHit_song_id());
			
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateGirlGroup(GirlGroup gg) {
		String sql = "update girl_group set name=?, debut=?, hit_song_id=? where gid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gg.getName());
			pstmt.setString(2, gg.getDebut().toString());
			pstmt.setInt(3, gg.getHit_song_id());
			pstmt.setInt(4, gg.getGid());
			
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteGirlGroup(int gid) {
		String sql = "delete from girl_group where gid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, gid);
			
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
