package ch10_oop.sec02_constructor;

public class Student extends Person {
	int studentID;

	// 생성자는 상속이 안 돼서 따로 호출 필요
	public Student(String name, int age, int studentID) {
		super(name, age); // 자식 클래스는 반드시 부모의 생성자를 호출해야 함, super는 부모의 생성자를 압축
		this.studentID = studentID;
	}
	
	public void study() {
		System.out.println(name + "이(가) 공부를 합니다.");
	}
}
