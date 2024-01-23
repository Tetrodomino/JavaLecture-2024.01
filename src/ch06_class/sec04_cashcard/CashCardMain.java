package ch06_class.sec04_cashcard;

import java.util.Scanner;

public class CashCardMain {

	public static void main(String[] args) {

		CashCard busCard = new CashCard(10000, 15);
		Scanner scan = new Scanner(System.in);
		int index = 1;
		
		while (index > 0)
		{
			System.out.println("기능을 선택하십시오.");
			System.out.println("0: 종료");
			System.out.println("1: 현금 충전");
			System.out.println("2: 버스 타기");
			System.out.println("3: 나이 입력");
			System.out.println("4: 카드 정보 확인");
			System.out.print("행동 입력: ");
			
			index = Integer.parseInt(scan.nextLine());
			
			if (index == 1)
			{
				System.out.print("충전할 금액 입력: ");
				int cash = index = Integer.parseInt(scan.nextLine());
				
				busCard.charge(cash);
				System.out.println();
			}
			else if (index == 2)
			{
				if (busCard.ride())
				{
					System.out.println("탑승 완료!");
				}
				else
					System.out.println("잔액이 부족합니다!");
			}
			else if (index == 3)
			{
				System.out.print("새 나이 입력: ");
				int age = index = Integer.parseInt(scan.nextLine());
				
				busCard.setAge(age);
				System.out.println();
			}
			else if (index == 4)
			{
				System.out.println(busCard.toString());
			}
		}
		
		scan.close();
	}

}
