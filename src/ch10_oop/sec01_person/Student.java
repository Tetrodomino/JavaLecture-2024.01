package ch10_oop.sec01_person;

public class Student extends Person {
	int studentID;
	
	public void study() {
		System.out.println(name + "이(가) 공부를 합니다."); // 부모 클래스 필드 사용 가능
	}
}
