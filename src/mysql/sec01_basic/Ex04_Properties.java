package mysql.sec01_basic;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Ex04_Properties {

	public static void main(String[] args) {

		// 절대 경로
		Properties prop = new Properties();		// Map<String, String> 형태
		
		String path = "C:/Workspace/Java/lesson/src/mysql/mysql.properties"; // 파일 경로
		
		
		try {
			InputStream is = new FileInputStream(path);
			
			// prop에 is의 데이터를 로드
			prop.load(is);
			
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 파일의 데이터를 변수에 대입
		String host = prop.getProperty("host");
		String port = prop.getProperty("port");
		String database = prop.getProperty("database");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		
		// user과 password만 빼고 데이터 출력
		String connStr = "jdbc:mysql://" + host + ":" + port + "/" + database;
		System.out.println(connStr);
		System.out.println("DriverManager.getConnnection(connStr, user, password);");
	}

}
