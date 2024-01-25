package ch17_collection.part3_map.sec04_property;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Ex01_Properties {
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties(); 	// Map<String, String>을 Properties라 함
		
		// database.properties 파일 로드
		// 같은 위치 내의 파일 로드
//		prop.load(Ex01_Properties.class.getResourceAsStream("database.properties"));
		
		// 파일 경로를 이용해서 파일 로드
		String filename = "C:\\Workspace\\Java\\lesson\\src\\ch17_collection\\part3_map\\sec04_property\\database.properties";
		InputStream is = new FileInputStream(filename);
		prop.load(is);
		is.close();
		
		// database 파일의 driver라는 값을 찾아서 해당 값이 가리키는 값을 리턴
		String driver = prop.getProperty("driver");
		System.out.println(driver);
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		System.out.println(prop.getProperty("admin"));
	}
}
