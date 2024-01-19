package ch10_oop.sec04_polymorphism;

public class Main {

	public static void main(String[] args) {
		
		Cat cat = new Cat();
		cat.sound();
		cat.jump();
		
		Dog dog = new Dog();
		dog.sound();
		dog.walk();
		
		// 다형성. 자식은 부모 타입으로 자동 타입 변환이 이루어짐
		Animal animal = new Cat();
		animal.sound(); // Cat 클래스가 되므로 야옹이 나옴
		// jump는 cat에만 정의됐으므로 안 됨
		
		animal = dog;
		animal.sound(); // 멍멍
		// walk는 안 됨
		
		
		Object object = cat; // 모든 클래스의 조상 Object로도 되지만
		//object.sound(); 오브젝트는 오브젝트에 있는 메소드만 실행 가능해서 안 됨
		
		
		animal = cat;
		cat = (Cat) animal; // 강제로 타입을 변환하면
		cat.jump(); //  Cat 클래스의 메소드 사용 가능
		
		// 실행할 경우 에러 발생
		//dog = (Dog) animal;
		//dog.walk(); 
		// animal에 cat을 대입한 상태에서는 강제 형변환을 해도 Dog만의 메소드 사용 불가
		
		animal = new Animal();
		
		if (animal instanceof Cat) { // animal = cat일 경우 실행 가능
			cat = (Cat) animal;
			cat.sound();
			cat.jump();
		} else if (animal instanceof Dog) { // animal = dog 일 경우 실행 가능
			dog = (Dog) animal;
			dog.sound();
			dog.walk();
		} else
		{
			System.out.println("cat.sound()/dog.sound() 등을 사용할 수 없음");
		}
	}
	
	

}
