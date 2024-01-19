package ch10_oop.sec04_polymorphism;

public class Dog extends Animal {
	
	// Override를 쓰지 않아도 걍 되지만 쓰는 것이 권장
	void sound() {
		System.out.println("멍멍!");
	}
	
	void walk() {}
}
