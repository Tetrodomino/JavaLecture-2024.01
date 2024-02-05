package mysql.secEx_song;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SongDao {

	private String connStr;
	private String user;
	private String password;
	
	public SongDao() {
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Connection myConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(connStr, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public Song getSongById(int id) {
		Connection conn = myConnection();
		String sql = "select * from song where sid=?";
		
		Song song = new Song();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				song.setSid(rs.getInt(1));
				song.setTitle(rs.getString(2));
				song.setLyric(rs.getString(3));				
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return song;
	}
	
	public Song getSongBtTitle(String title) {
		Connection conn = myConnection();
		String sql = "select * from song where title=?";
		
		Song song = new Song();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				song.setSid(rs.getInt(1));
				song.setTitle(rs.getString(2));
				song.setLyric(rs.getString(3));				
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return song;
	}
	
	public List<Song> getSongList() {
		Connection conn = myConnection();
		String sql = "select * from song";
		
		List<Song> list = new ArrayList<Song>();
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Song song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3));
				
				list.add(song);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Song> getSongListRange(int start, int end) {
		Connection conn = myConnection();
		String sql = "select * from song where sid>=? AND sid<=?";
		
		List<Song> list = new ArrayList<Song>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Song song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3));
				
				list.add(song);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void insertSong(Song song) {
		Connection conn = myConnection();
		String sql = "insert into song values(default, ?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, song.getTitle());
			pstmt.setString(2, song.getLyric());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateSong(Song song) {
		Connection conn = myConnection();
		String sql = "update song set title=?, lyrics=? where sid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, song.getTitle());
			pstmt.setString(2, song.getLyric());
			pstmt.setInt(3, song.getSid());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteSong(int sid) {
		Connection conn = myConnection();
		String sql = "delete from song where sid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, sid);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
