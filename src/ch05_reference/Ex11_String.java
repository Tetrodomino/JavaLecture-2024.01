package ch05_reference;

public class Ex11_String {

	public static void main(String[] args) {
		
		// 문자열 생성 방법
		String str1 = new String("문자열");
		String str2 = "문자열";
		
		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97}; // Hello Java의 아스키 코드
		String str3 = new String(bytes);
		
		System.out.printf("%s, %s, %s%n", str1, str2, str3);
		
		String str4 = "문자열";
		System.out.println(str2 == str4); // str2와 str4가 가리키는 곳이 동일
		
		Person james = new Person("제임스", 29, "프로그래머");
		Person maria = new Person("마리아", 23, "학생");
		
		System.out.println(james); // Person 내의 toString이 자동으로 작동해서 출력됨
		System.out.println(maria);
	}

}
