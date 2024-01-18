package ch06_class.sec04_cashcard;

import java.util.Scanner;

public class CashCardMain2 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("나이: ");
		int age = Integer.parseInt(scan.nextLine());
		
		System.out.print("금액: ");
		int cash = scan.nextInt();
		
		scan.close();
		
		CashCard card = new CashCard(cash, age);
		System.out.println(card);
		
		for (int i = 1; i < Integer.MAX_VALUE; i++)
		{
			if (!card.ride())
				break;
			System.out.print(i + "회 탑승 후 ");
			System.out.println(card);
		}
	}
}
