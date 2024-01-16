package ch04_control;

import java.util.Scanner;

public class Ex02_leapyear {

	public static void main(String[] args) {
		
		System.out.print("연도 입력: ");
		
		Scanner scan = new Scanner(System.in);
		
		int year = Integer.parseInt(scan.nextLine()); // scan으로 읽은 값 숫자로 전환하기
		scan.close();
		
		String s = "평년";

		if (year % 4 == 0)
			s = "윤년";
		if (year % 100 == 0)
			s = "평년";
		if (year % 400 == 0)
			s = "윤년";
		
		System.out.println(year + "년은 " + s + " 입니다.");
		
	}

}
