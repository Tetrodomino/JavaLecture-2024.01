package ch12_interface.sec12_bank_refactory;

public interface AccountService {
	
	int DELETED = 1; // public static final 이 생략된 상수

	void createAccount();
	
	void accountList();
	
	void deposit();
	
	void withdraw();
	
	Account findAccount(String ano);
	
	void delete();
}
