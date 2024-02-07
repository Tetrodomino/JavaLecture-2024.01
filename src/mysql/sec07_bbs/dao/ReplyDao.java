package mysql.sec07_bbs.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mysql.sec07_bbs.entity.Reply;

public class ReplyDao {

	private String connStr;
	private String user;
	private String password;
	private Connection conn;
	
	public ReplyDao() {
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
	
	public Reply getReply(int rid) {
		String sql = "select * from reply where rid=? and isDeleted=0";
		
		Reply r = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rid);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				String time = rs.getString(3);
				time = time.replace(" ", "T");
				
				r = new Reply(rs.getInt(1), rs.getString(2), LocalDateTime.parse(time),
						rs.getString(4), rs.getInt(5));
			}
			
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return r;
	}
	
	public List<Reply> getReplyList(int bid) {
		String sql = "select * from reply where bid=? and isDeleted=0";
		
		List<Reply> list = new ArrayList<Reply>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bid);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				String time = rs.getString(3);
				time = time.replace(" ", "T");
				
				Reply r = new Reply(rs.getInt(1), rs.getString(2), LocalDateTime.parse(time),
						rs.getString(4), rs.getInt(5));
				
				list.add(r);
			}
			
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public void insertReply(Reply reply) {
		String sql = "insert into reply values (default, ?, default, ?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reply.getComment());
			pstmt.setString(2, reply.getUid());
			pstmt.setInt(3, reply.getBid());
			
			ResultSet rs = pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
