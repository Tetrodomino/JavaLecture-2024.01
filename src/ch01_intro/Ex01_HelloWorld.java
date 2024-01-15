package ch01_intro;

// class 이름은 대문자로 시작시킨다
public class Ex01_HelloWorld {
	
	// method 중 main은 소문자로 시작
	// Java는 항상 main으로 시작
	public static void main(String[] args) {
		
		// 출력시키는 명령어
		// println() 안에는 문자열이 하나만 올 수 있음 ( , 등으로 여러 문자열 동시에 사용 불가)
		System.out.println("Hello World!");
		System.out.println("안녕하세요" + "여러분");
		
		// 'syso' + ctrl + space로 입력 가능
	}
	
	
	/**
	 * 도큐먼트 주석(/** 으로 만들 수 있음) - API document 만들 때 사용
	 * @param args
	 */
	
	
}
