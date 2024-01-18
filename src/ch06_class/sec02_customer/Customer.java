package ch06_class.sec02_customer;

public class Customer {
	private int cid;
	private String name;
	private int age;
	private boolean adult;
	
	
	// 생성자
	// - 클래스를 생성시키는 방법을 정의하는 것
	// - 클래스의 이름과 같음
	// - 대문자로 시작하는 것이 좋음
	// - void도 없이 return 타입이 존재하지 않음
	public Customer() {}
	
	public Customer(int cid, String name, int age) {
		this.cid = cid;
		this.name = name;
		this.age = age;
		this.adult = (age > 19) ? true : false;
	}

	public Customer(int cid, String name, int age, boolean adult) {
		this.cid = cid;
		this.name = name;
		this.age = age;
		this.adult = adult;
	}

	

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", age=" + age + ", adult=" + adult + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isAdult() { // boolean 타입은 is로 이름이 생성
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}
	
	
}
