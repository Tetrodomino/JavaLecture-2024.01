package ch10_oop.example20;

import java.util.Scanner;

public class BankApplication {

	private static Account[] accountArray = new Account[100];
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		boolean run = true;
		
		while (run) {
			System.out.println("───────────────────────────────────────────────────────");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("───────────────────────────────────────────────────────");
			System.out.print("선택: ");
			
			int selectNo = scan.nextInt();
			scan.nextLine();
			
			if (selectNo == 1) {
				creatAccount();
			}
			else if (selectNo == 2) {
				accountList();
			}
			else if (selectNo == 3) {
				deposit();
			}
			else if (selectNo == 4) {
				withdraw();
			}
			else
			{
				run = false;
				System.out.println("프로그램 종료");
			}
			
		}
	}
	
	private static void creatAccount() {
		System.out.println("------------");
		System.out.println("계좌생성");
		System.out.println("------------");
	
		System.out.print("계좌번호: ");
		String ano = scan.nextLine();
		
		System.out.print("계좌주: ");
		String person = scan.nextLine();
		
		System.out.print("초기입금액: ");
		int balance = Integer.parseInt(scan.nextLine());
		
		if (balance < 0)
		{
			System.out.println("결과: 허용되지 않는 액수입니다.");
			return;
		} 
		
		for (int i = 0; i < 100; i++) 
		{
			if (accountArray[i] == null)
			{
				Account account = new Account(ano, person, balance);
				accountArray[i] = account;
				System.out.println("결과: 계좌가 생성되었습니다.");
				return;
			}
			else
			{
				Account account = accountArray[i];
				if (ano.equals(account.getAno()))
				{
					System.out.println("결과: 중복되는 계좌번호가 존재합니다.");
					return;
				}
			}
		}
		System.out.println("결과: 계좌 생성 실패.");
	}
	
	private static void accountList () {
		System.out.println("------------");
		System.out.println("계좌목록");
		System.out.println("------------");
		
		for (int i = 0; i < 100; i++)
		{
			if (accountArray[i] == null)
				break;
			else
				System.out.printf("%-9s %6s \t %d\n", accountArray[i].getAno(), accountArray[i].getOwner(), accountArray[i].getBalance());
		}
	}
	
	private static void deposit() {
		System.out.println("------------");
		System.out.println("예금");
		System.out.println("------------");
		
		System.out.print("계좌번호: ");
		String ano = scan.nextLine();
		
		int check = -1;
		for (int i = 0; i < 100; i++)
		{
			if (accountArray[i] != null)
			{		
				Account account = accountArray[i];
				if (ano.equals(account.getAno()))
				{
					check = i;
					break;
				}
			}
		}
		if (check == -1)
		{
			System.out.println("결과: 없는 계좌번호입니다.");
			return;
		}
		
		System.out.print("예금액: ");
		int balance = Integer.parseInt(scan.nextLine());
		
		if (balance < 1)
		{
			System.out.println("결과: 허용되지 않은 행동입니다.");
			return;
		}
		
		accountArray[check].setBalance(accountArray[check].getBalance() + balance);
		System.out.println("결과: 예금이 성공되었습니다.");
	}
	
	private static void withdraw() {
		System.out.println("------------");
		System.out.println("출금");
		System.out.println("------------");
		
		System.out.print("계좌번호: ");
		String ano = scan.nextLine();
		
//		int check = -1;
				
		Account account1 = findAccount(ano);
		if (account1 == null)
		{
			System.out.println("결과: 없는 계좌번호입니다.");
			return;
		}
//		for (int i = 0; i < 100; i++)
//		{
//			if (accountArray[i] != null)
//			{		
//				Account account = accountArray[i];
//				if (ano.equals(account.getAno()))
//				{
//					check = i;
//					break;
//				}
//			}
//		}
		
		System.out.print("출금액: ");
		int balance = Integer.parseInt(scan.nextLine());
		
		if (balance < 1)
		{
			System.out.println("결과: 허용되지 않은 행동입니다.");
			return;
		}
		else if (balance > account1.getBalance())
		{
			System.out.println("결과: 예금액을 초과했습니다.");
			return;
		}
		
		account1.setBalance(account1.getBalance() - balance); // 굳이 몇 번째인지 안 찾아도 무방
		//accountArray[check].setBalance(accountArray[check].getBalance() - balance);
		System.out.println("결과: 출금이 성공되었습니다.");
	}
	
	private static Account findAccount(String ano) {
		for (int i = 0; i < 100; i++)
		{
			if (accountArray[i] != null)
			{		
				Account account = accountArray[i];
				if (ano.equals(account.getAno()))
				{
					return account;
				}
			}
		}
		
		return null;
	}
}
