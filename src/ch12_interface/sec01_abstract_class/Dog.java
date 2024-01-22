package ch12_interface.sec01_abstract_class;

public class Dog extends Animal {

	
	// 부모 클래스 Animal에 있는 추상클래스 cry를 오버라이드
	// 만약 부모 클래스의 추상클래스를 오버라이드 하지 않으면 에러가 뜸
	@Override
	void cry() {
		System.out.println("멍멍");
	}

}
