package ch10_oop.sec05_equals;

import java.util.Objects;

public class Customer {
	private int cid;
	private String name;
	private int age;
	private boolean adult;
	
	public Customer() {}
	
	public Customer(int cid, String name, int age, boolean adult) {
		this.cid = cid;
		this.name = name;
		this.age = age;
		this.adult = adult;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Customer)
		{
			Customer customer = (Customer) obj;
			
			// cid 값만 같으면 동일한 객체
			// return this.cid == ((Customer) obj).getCid();
			
			// cid와 name 값이 같으면 동일한 객체로 판단
			//return customer.getCid() == cid && customer.getName() == name;
			
			// 위랑 같으나 조금 다른 방식
			return this.cid == ((Customer) obj).getCid() && this.name == ((Customer) obj).getName(); 
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cid, age);
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

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}
	
	
}
