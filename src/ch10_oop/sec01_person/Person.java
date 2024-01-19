package ch10_oop.sec01_person;

public class Person {
	String name;
	int age;
	
	public void eat() {
		System.out.println(name + "이(가) 식사를 합니다.");
	}
	
	public void sleep() {
		System.out.println(name + "이(가) 잠을 잡니다.");
	}
}
