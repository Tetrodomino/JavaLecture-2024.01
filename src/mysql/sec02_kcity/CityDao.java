package mysql.sec02_kcity;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * City DAO(Data Access Object)
 * - DB 테이블을 다루는 라이브러리
 * - SELECT, INSERT, UPDATE, DELETE를 처리하는 프로그램
 */
public class CityDao {

	private String connStr;
	private String user;
	private String password;
	
	public CityDao() {
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
	
	// ID를 입력해서 City를 받아오는 메소드
	public City getCityById(int id) {
		Connection conn = myConnection(); // Connection 생성
		String sql = "select * from kcity where id=?";
		
		/////////////////////////////////////////////////////////////
		// 클래스에 데이터를 받는 방법 1
		City city = new City(); 
		
		try {
			// 파라메터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			// 셀렉트 실행하고 결과 받기
			ResultSet rs = pstmt.executeQuery();
			
			// 받은 결과에 데이터 받기
			while(rs.next()) {
				city.setId(rs.getInt(1)); 
				city.setName(rs.getString(2));
				city.setCountryCode(rs.getString(3));
				city.setDistrict(rs.getString(4));
				city.setPopulation(rs.getInt(5));
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/////////////////////////////////////////////////////////////
		
		
		/////////////////////////////////////////////////////////////
		// 클래스에 데이터를 받는방법 2
		Connection conn2 = myConnection();
		City city2 = null;
		
		try {
			PreparedStatement pstmt2 = conn2.prepareStatement(sql);
			
			pstmt2.setInt(1, id);
			
			// 셀렉트 실행하고 결과 받기
			ResultSet rs2 = pstmt2.executeQuery();
			
			// 받은 결과에 데이터 받기
			while(rs2.next()) {
				city2 = new City(rs2.getInt(1), rs2.getString(2),
						rs2.getString(3), rs2.getString(4), rs2.getInt(5));
			}
			
			rs2.close();
			pstmt2.close();
			conn2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/////////////////////////////////////////////////////////////
		
		return city;
	}
	
	public City getCityByName(String name) {
		Connection conn = myConnection();
		String sql = "select * from kcity where name=?"; // id에서 name으로 변경
		
		City city = null;
		
		try {
			// 파라메터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			// select를 실행하고 결과를 resultset으로 받기
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				city = new City(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getInt(5));
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return city;
	}
	
	public List<City> getCityListAll() {
		Connection conn = myConnection();
		String sql = "select * from kcity";
		
		List<City> list = new ArrayList<City>();
		
		try {
			Statement stmt = conn.createStatement();
			
			// Select 실행하고 결과를 ResultSet으로 받기
			ResultSet rs = stmt.executeQuery(sql);
			
			// 받은 Set의 데이터를 city 클래스에 넣고 리스트에 추가
			while (rs.next())
			{
				City city = new City(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getInt(5));
				
				list.add(city);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<City> getCityListByDistrict(String district)
	{
		Connection conn = myConnection();
		String sql = "select * from kcity where district=?";
		
		List<City> list = new ArrayList<City>();
		
		try {
			// 파라메터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
						
			pstmt.setString(1, district);
			
			// Select 실행하고 결과를 ResultSet으로 받기
			ResultSet rs = pstmt.executeQuery();
			
			// 받은 Set의 데이터를 city 클래스에 넣고 리스트에 추가
			while (rs.next())
			{
				City city = new City(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getInt(5));
				
				list.add(city);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void insertCity(City city) {
		Connection conn = myConnection();
		String sql = "insert into kcity values(default, ?, ?, ?, ?)";
		
		try {
			// 파라메터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, city.getName());
			pstmt.setString(2, city.getCountryCode());
			pstmt.setString(3, city.getDistrict());
			pstmt.setInt(4, city.getPopulation());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateCity(City city) {
		Connection conn = myConnection();
		String sql = "update kcity set name=?, countrycode=?, district=?, population=? where id=?";
		
		try {
			// 파라메터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, city.getName());
			pstmt.setString(2, city.getCountryCode());
			pstmt.setString(3, city.getDistrict());
			pstmt.setInt(4, city.getPopulation());
			pstmt.setInt(5, city.getId());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCity(int id) {
		Connection conn = myConnection();
		String sql = "delete from kcity where id=?";
		
		try {
			// 파라메터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
