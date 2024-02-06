package mysql.sec05_message;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MessageDao {

	private String connStr;
	private String user;
	private String password;
	private Connection conn;
	
	public MessageDao() {
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
	
	public Message getMessageByMid(int mid) {
		String sql = "select * from message where mid=?";
		
		Message m = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				if (rs.getInt(5) != 0)
					continue;
				
				String time = rs.getString(4);
				time = time.replace(" ", "T");
				
				m = new Message(mid, rs.getString(2), rs.getString(3),
						LocalDateTime.parse(time), rs.getInt(5));
			}
			pstmt.close();
			rs.close();
			
			return m;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Message> getMessageList() {
		String sql = "select * from message";
		List<Message> list = new ArrayList<Message>();
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				if (rs.getInt(5) != 0)
					continue;
				Message m = new Message(rs.getInt(1), rs.getString(2),
						rs.getString(3), null, rs.getInt(5));
				
				String time = rs.getString(4);
				time = time.replace(" ", "T");
				
				m.setModTime(LocalDateTime.parse(time));
				
				list.add(m);
			}
			
			stmt.close();
			rs.close();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Message> getMessageByWriter(String writer) {
		String sql = "select * from message where writer like ?";
		List<Message> list = new ArrayList<Message>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				if (rs.getInt(5) != 0)
					continue;
				Message m = new Message(rs.getInt(1), rs.getString(2),
						rs.getString(3), null, rs.getInt(5));
				
				String time = rs.getString(4);
				time = time.replace(" ", "T");
				
				m.setModTime(LocalDateTime.parse(time));
				
				list.add(m);
			}
			pstmt.close();
			rs.close();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void insertMessage(Message msg) {
		String sql = "insert into message values(default, ?, ?, default, default)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, msg.getContent());
			pstmt.setString(2, msg.getWriter());
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateMessage(Message msg) {
		String sql = "update message set content=?, writer=?, modTime=? where mid=?";
		//sql = "update message set content=?, writer=?, modTime=now() where mid=?"; 로도 가능
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, msg.getContent());
			pstmt.setString(2, msg.getWriter());
			pstmt.setInt(4, msg.getMid());
			
			LocalDateTime n = LocalDateTime.now();
			String nowt = n.toString().replace("T", " ");
			nowt = nowt.substring(0, 19);
			
			pstmt.setString(3, nowt);
			
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteMessage(int mid) {
		String sql = "update message set isDeleted=? where mid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, mid);
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
