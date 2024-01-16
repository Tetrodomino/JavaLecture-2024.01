package ch02_type;

import java.io.IOException;
import java.util.Scanner;

public class Ex04_input {

	public static void main(String[] args) throws IOException {
		
		// 하나의 문자를 읽을 때 사용
		// int keyCode = System.in.read();
		
		// System.out.println("keyCode: " + keyCode); // 5 입력 시 0x35 → 10진법으로 나타내면 53
	
		Scanner scan = new Scanner(System.in); // Scanner 객체 생성
		
		System.out.print("입력하세요: ");
		String inputText = scan.nextLine();		// 엔터를 칠 때까지의 문자열을 읽기
		System.out.println(inputText);
		
		scan.close(); // 더 이상 사용하지 않게 된 scanner(system.in)은 close 해야 주의사항이 안 뜸
	}

}
