package ch14_exception;

public class Ex02_Unchecked {

	public static void main(String[] args) {
		
		// 컴파일은 되지만 실행에서 오류가 나는 에러
		try {
			System.out.println(3 / 0);	// 0으로 나누기		
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		
		int[] intArray = new int[3];
		
		try {			
			System.out.println(intArray[3]); // 범위 밖의 배열 출력
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		String str = null;
		try {			
			System.out.println(str.length()); // null 스트링의 길이 구하기
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		str = "100원";
		try {			
			int value = Integer.parseInt(str); // number가 아닌 값이 섞여있는 스트링을 int로 만들기
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		Animal a1 = new Cat();
		Animal a2 = new Dog();
		
		try {
			Cat cat = (Cat) a1;
			cat = (Cat) a2;			 // 다른 유형의 클래스를 대입하기
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램의 마지막 줄");
	}

}

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}
