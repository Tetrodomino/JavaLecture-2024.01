package ch04_control;

import java.util.Scanner;

public class Ex99_clock {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("시: ");
		int hour = Integer.parseInt(scan.nextLine());
		
		System.out.print("분: ");
		int minute = Integer.parseInt(scan.nextLine());
		
		scan.close();
		
		System.out.printf("%02d : %02d", hour, minute);
		
		minute -= 45;
		
		if (minute < 0)
		{
			hour -= 1;
			minute += 60;
		}
		
		if (hour < 0)
		{
			hour += 24;
		}
		
		System.out.printf(" 의 45분 전 - %02d : %02d", hour, minute);
	}

}
