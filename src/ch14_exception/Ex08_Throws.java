package ch14_exception;

public class Ex08_Throws {
	public static void main(String[] args) throws Exception {
//		try {
//			findClass();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("클래스를 찾지 못했습니다");
//		}
		
		findClass();
	}
	
	// ClassNotFoundException에 해당하는 오류 떠넘기기
	static void findClass() throws ClassNotFoundException {
		Class<?> clazz = Class.forName("java.lang.Stirng2");
	}
}
