package ch12_interface.sec12_bank_refactory;

public interface AccountService {

	void createAccount();
	
	void accountList();
	
	void deposit();
	
	void withdraw();
	
	Account findAccount(String ano);
}
