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

import mysql.sec07_bbs.entity.Board;

public class BoardDao {

	private String connStr;
	private String user;
	private String password;
	private Connection conn;
	
	public BoardDao() {
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
	
	public Board getBoard(int bid) {
		String sql = "SELECT b.*, u.uname FROM board b"
				+ "	JOIN users u ON b.uid = u.uid"
				+ "	WHERE b.bid=? AND b.isDeleted=0";
		
		Board b = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				String time = rs.getString(5);
				time = time.replace(" ", "T");
				
				b = new Board(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), LocalDateTime.parse(time), rs.getInt(6),
						rs.getInt(7), rs.getInt(8), rs.getString(9));
			}
			
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	// field는 제목, 내용, 작성ID 등 검색 옵션
	// query 값은 검색어
	public List<Board> getBoardList(String field, String query, int num, int offset) {
		String sql = "SELECT b.*, u.uname FROM board b"
				+ "	JOIN users u ON b.uid=u.uid"
				+ "	WHERE b.isdeleted=0 AND " + field + " LIKE ?"
				+ "	ORDER BY bid DESC"
				+ "	LIMIT ? OFFSET ?";
		
		List<Board> list = new ArrayList<Board>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%" + query + "%");
			pstmt.setInt(2, num);
			pstmt.setInt(3, offset);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String time = rs.getString(5);
				time = time.replace(" ", "T");
				
				Board b = new Board(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), LocalDateTime.parse(time), rs.getInt(6),
						rs.getInt(7), rs.getInt(8), rs.getString(9));
				
				list.add(b);
			}
			
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public void insertBoard(Board board) {
		String sql = "insert into board values(default, ?, ?, ?, default, default, default, default)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getUid());
			
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateBoard(Board board) {
		String sql = "update board set title=?, content=?, modTime=now() where bid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBid());
			
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBoard(int bid) {
		String sql = "update board set isDeleted=1 where bid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// field는 view 또는 reply
	public void increaseCount(String field, int bid) {
		String sql = "UPDATE board SET " + field + "Count = " + field + "Count + 1 WHERE bid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
