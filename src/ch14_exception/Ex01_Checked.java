package ch14_exception;

import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01_Checked {

	public static void main(String[] args) {
		// 컴파일 에러는 발생할 경우 아예 실행되지 않음
		
		// 예외처리 하기
		try {
			Thread.sleep(1000); // 잘못된 코드
		} catch (InterruptedException e) { // 에러가 발생할 때 실행될 코드
			e.printStackTrace();
		}
		
		try {
			Class cls = Class.forName("java.lang.Kobject");
		} catch (ClassNotFoundException e) { // 없는 클래스를 참조할 때 발생
			e.printStackTrace();
		}
		
		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			isr.read();
		} catch (IOException e) { // IOException 에러
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("프로그램의 마지막 줄");
	}
}
