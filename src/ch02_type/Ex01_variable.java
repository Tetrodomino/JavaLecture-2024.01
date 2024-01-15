package ch02_type;

public class Ex01_variable {
	
	private static int num = 3;

	public static void main(String[] args) {
		
		//자료형
		
		// 변수를 선언할 때 자료형을 반드시 붙여야 함
		int age; // 정수형
		age = 21;
		int score = 88;	// 선언하면서 초기화 하는 것이 권장
		
		
		var value = age * score; // 값의 형태를 판단하여 스스로 어떤 자료형인지 판단하는 자료형. Java 8에서는 사용 불가
		
		// 변수 출력시키기 예시
		System.out.println("age: " + age + ", score: " + score + ", value: " + value);
		
		
		/*
		 * 변수이름 규칙
		 * 
		 * 1. 영문과 한글 사용 가능
		 * 
		 * 2. 특수문자는 _ 랑 $ 만 허용 
		 * 
		 * 3. 숫자도 사용 가능하나 이름의 맨 앞에 올 수 없음
		 * 
		 * 4. 자바에서 사용중인 키워드 (System 등) 사용 불가
		 * 
		 * 
		 * 권고사항
		 * 
		 * 1. 변수의 이름은 소문자로 시작하는 것을 권장
		 * 
		 * 2. 두 개 이상의 단어가 결합된 변수명은 두 번째부터의 단어의 맨 앞은 대문자로 하길 권장
		 * ex) go + school → goSchool
		 * 
		 * 
		 * 상수 이름 규칙
		 * 
		 * - 상수는 모든 글자를 대문자로 표현하는 것이 권장
		 * 
		 * - 두 개 이상의 단어가 붙으면 사이에 언더바를 넣는 것이 권장
		 * ex) NUM_EXP
		 */
		
		
		
		/*
		 * 변수 라이프 사이클
		 * 
		 * - 기본적으론 모든 변수는 선언된 블록 { } 안에서만 유효
		 */
		
		if (age >= 19) {
			System.out.println("음주 허용");
			int num = 2;
			System.out.println(num); // 2 출력
		}
		
		System.out.println(num); // 3 출력
	}
}
