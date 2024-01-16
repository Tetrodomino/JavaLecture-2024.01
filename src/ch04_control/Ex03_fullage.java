package ch04_control;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex03_fullage {
	
	/******     만 나이 입력받기      ******/

	public static void main(String[] args) {
		// 현재 연도와 날짜 입력받기
		LocalDate today = LocalDate.now();
		
		//System.out.println(today);
		
		int year = today.getYear();			// 연
		int month = today.getMonthValue();	// 월
		int day = today.getDayOfMonth();	// 일
		
		System.out.printf("현재 날짜: %d, %d, %d%n", year, month, day);

		Scanner scan = new Scanner(System.in);
		System.out.print("생년: ");
		int birthYear = Integer.parseInt(scan.nextLine());
		
		System.out.print("생월: ");
		int birthMonth = Integer.parseInt(scan.nextLine());
		
		System.out.print("생일: ");
		int birthDay = Integer.parseInt(scan.nextLine());
		
		scan.close();
		
		int age = 0;
		
		age = year - birthYear;
		
		if (birthMonth > month)
			age--;
		else if (birthMonth == month && birthDay > day)
			age--;
		
		System.out.println("당신의 나이: " + age);
		
		// 삼항연산자 사용 방식
		int age2 = (birthMonth > month || (birthMonth == month && birthDay > day)) ? year - birthYear - 1 : year - birthYear;
	}

}
