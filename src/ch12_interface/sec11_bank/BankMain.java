package ch12_interface.sec11_bank;

import java.util.Scanner;

public class BankMain {
	private static Account[] accountArray = new Account[100];
	private static Scanner scan = new Scanner(System.in);
	private static AccountService accountService = new AccountServiceimpl();
	
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
				accountService.createAccount(accountArray);
			}
			else if (selectNo == 2) {
				accountService.accountList(accountArray);
			}
			else if (selectNo == 3) {
				accountService.deposit(accountArray);
			}
			else if (selectNo == 4) {
				accountService.withdraw(accountArray);
			}
			else
			{
				run = false;
				System.out.println("프로그램 종료");
			}
			
		}
	}

}
