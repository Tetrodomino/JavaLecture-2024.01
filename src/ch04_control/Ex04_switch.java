package ch04_control;

public class Ex04_switch {

	public static void main(String[] args) {

		String s = "Hello";
		
		System.out.println(s.equals("hello")); // false 출력
		
		
		switch(s) // switch는 if랑 달리 문자열의 비교가 가능 (C언어에선 불가능)
		{
		case "Hello":
			System.out.println(true); // true 출력
			break;
		case "hello":
			System.out.println("대소문자 구분");
			break;
		default:
			System.out.println(false);
		}
	}

}
