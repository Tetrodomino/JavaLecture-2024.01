package ch04_control;

import java.util.Scanner;

public class Ex99_star {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("라인의 수: ");
		
		int line = Integer.parseInt(scan.nextLine()) / 2;
		
		scan.close();
		
		for (int i = 0; i <= line; i++)
		{
			int center = line / 2 - 1;
			
			for (int j = 1; j <= line - 1; j++)
			{
				System.out.print(" ");
			}
			for (int j = 1; j <= 2*i+1; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
