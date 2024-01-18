package ch06_class.sec04_cashcard;

public class CashCard {

	private int cash = 0;
	private int age = 0;
	
	// final을 붙이면 실행 후 수정 불가
	public static final int CHILD_FARE = 730;
	public static final int YOUTH_FARE = 1010;
	public static final int ADULT_FARE = 1450;
	
	public CashCard() {}
	
	public CashCard(int cash, int age) {
		this.cash = cash;
		this.age = age;
	}
	
	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "CashCard [cash=" + cash + ", age=" + age + "]";
	}

	public void charge(int cash) {
		this.cash += cash;
	}
	
	public boolean ride() {
		int cost = 0;
		
		if (this.age >= 7 && this.age < 13)
			cost = CHILD_FARE;
		else if (this.age < 19)
			cost = YOUTH_FARE;
		else if (this.age >= 19)
			cost = ADULT_FARE;
		
		if (this.cash >= cost)
		{	
			this.cash -= cost;
			return true;
		}
			
		return false;
	}
}
