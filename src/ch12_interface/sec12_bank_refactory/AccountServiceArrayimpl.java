package ch12_interface.sec12_bank_refactory;

import java.util.Scanner;

public class AccountServiceArrayimpl implements AccountService{

	private static Scanner scan = new Scanner(System.in);
	private static Account[] accountArray = new Account[100];
	
	@Override
	public void createAccount() {
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

	@Override
	public void accountList() {
		System.out.println("------------");
		System.out.println("계좌목록");
		System.out.println("------------");
		
		for (int i = 0; i < 100; i++)
		{

			
			if (accountArray[i] == null)
				break;
			// 해당 계좌가 삭제된 상태면 출력하지 않음
			else if (accountArray[i].getIsDeleted() == AccountService.DELETED)
				continue;
			else
				System.out.printf("%-9s %6s \t %d\n", accountArray[i].getAno(), accountArray[i].getOwner(), accountArray[i].getBalance());
		}
	}

	@Override
	public void deposit() {
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

	@Override
	public void withdraw() {
		System.out.println("------------");
		System.out.println("출금");
		System.out.println("------------");
		
		System.out.print("계좌번호: ");
		String ano = scan.nextLine();
				
		Account account1 = findAccount(ano);
		if (account1 == null)
		{
			System.out.println("결과: 없는 계좌번호입니다.");
			return;
		}
		
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
		
		account1.setBalance(account1.getBalance() - balance);
		System.out.println("결과: 출금이 성공되었습니다.");
	}

	@Override
	public Account findAccount(String ano) {
		for (int i = 0; i < 100; i++)
		{
			if (accountArray[i] != null)
			{		
				Account account = accountArray[i];
				if (ano.equals(account.getAno()) && account.getIsDeleted() != AccountService.DELETED)
				{
					return account;
				}
			}
		}
		
		return null;
	}

	// 계좌 삭제하는 함수
	@Override
	public void delete() {
		System.out.println("------------");
		System.out.println("삭제");
		System.out.println("------------");
		
		System.out.print("계좌번호: ");
		String ano = scan.nextLine();
		Account account = findAccount(ano);
		if (account == null)
		{
			System.out.println("결과: 없는 계좌번호입니다.");
			return;
		}
		
		// AccountService의 DELETED 호출하여 setIsDeleted로 삭제된 상태를 나타내는 필드에 대입
		account.setIsDeleted(AccountService.DELETED);
	}

}
