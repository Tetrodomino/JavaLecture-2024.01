package ch05_reference;

public class Ex12_Stringmethod {

	public static void main(String[] args) {
		
		// String의 메소드
		String str1 = "Hello Java!";
		String str2 = "안녕하세요? 반갑습니다.";
		
		// 1. length() : 스트링의 길이
		System.out.println(str1.length() + ", " + str2.length()); // 11, 13
		
		
		// 2. charAt(n) : n번째 문자열 검색
		System.out.println(str2.charAt(0) + ", " + str2.charAt(7)); // 안, 반
		
		// ※ str[n] 의 형태로는 사용 불가 (python이나 javascript는 가능)
		
		// 2-1. 주민등록번호를 입력받아서 남자인지 여자인지 구별
		String ssn = "012345-1234567";
		char gender = ssn.charAt(7);
		switch(gender) {
		case '1':
		case '3':
			System.out.println("남자");
			break;
		case '2':
		case '4':
			System.out.println("여자");
			break;
		default:
			System.out.println("성별");
		}
	}

}
