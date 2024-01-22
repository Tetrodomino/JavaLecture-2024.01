package ch12_interface.sec01_abstract_class;

public class Main {

	public static void main(String[] args) {

		// 추상클래스는 객체 생성이 되지 않음
//		Animal animal = new Animal() ────→ 오류 발생
		
		
		// 이하의 행동은 가능
		Cat cat = new Cat();
		cat.cry();
		
		Dog dog = new Dog();
		dog.cry();
		
		Animal animal = new Cat();
		animal.cry();
	}

}
