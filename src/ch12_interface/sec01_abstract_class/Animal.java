package ch12_interface.sec01_abstract_class;

// 추상클래스 Animal 생성
public abstract class Animal {
	//추상메소드 생성
	//추상메소드는 안에 아무것도 정해지지 않은 메소드를 의미, 자식 클래스 등에서 오버라이드 할 때 사용
	abstract void cry();
}
