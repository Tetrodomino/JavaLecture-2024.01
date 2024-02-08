package mysql.sec07_bbs.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mysql.sec07_bbs.entity.User;

// DB 관련을 처리하는 클래스
public class UserDao {

	private String connStr;
	private String user;
	private String password;
	private Connection conn;
	
	public UserDao() {
		String path = "C:/Workspace/Java/lesson/src/mysql/sec07_bbs/mysql.properties";
		
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
	
	public User getUserByUid(String uid) {
		String sql = "select * from users where uid=? and isDeleted=0";
		
		User u = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				u = new User(uid, rs.getString(2), rs.getString(3),
						rs.getString(4), LocalDate.parse(rs.getString(5)), rs.getInt(6));
			}
			pstmt.close();
			rs.close();
			
			return u;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<User> getUserList(int num, int offset) {
		String sql = "select * from users where isDeleted=0"
				+ " order by regDate desc, uid limit ? offset ?";
		
		List<User> list = new ArrayList<User>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, offset);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				User u = new User(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), LocalDate.parse(rs.getString(5)), rs.getInt(6));
				
				list.add(u);
			}
			
			pstmt.close();
			rs.close();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void insertUser(User user) {
		String sql = "insert into users values(?, ?, ?, ?, default, default)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUid());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getUname());
			pstmt.setString(4, user.getEmail());
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user) {
		String sql = "update users set pwd=?, uname=?, email=? where uid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPwd());
			pstmt.setString(2, user.getUname());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getUid());
			
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String uid) {
		String sql = "update users set isDeleted=1 where uid=1";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
