package ch05_reference;

import java.nio.charset.Charset;
import java.util.Arrays;

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
		
		
		
		
		
		// 3. indexOf(s) : 찾고자 하는 문자열 s의 위치 (찾는 문자열의 맨 앞 자리가 위치로 반환)
		System.out.println(str1.indexOf("Java") + ", " + str2.indexOf('반')); // 6, 7
		
		// 3-1. indexOf를 boolean처럼 쓰려면 0 이상의 값이 나오는지 확인
		if (str1.toLowerCase().indexOf("java") >= 0)
			System.out.println("문장 안에 java가 있습니다");
		
		// 3-2. LastIndexOf(s) : indexOf랑 동일하지만 뒤에서부터 찾기
		System.out.println("apple pineapple".lastIndexOf("pp")); // 11
		
		
		
		
		
		
		// 4. String.valueOf(a) : a를 문자열로 변환
		boolean a = true;
		int b = 123;
		double c = 3.14;
		char d = 'a';
		
		// 명시적 변환
		System.out.println(String.valueOf(a) + ", " + String.valueOf(b) + ", " +
				String.valueOf(c) + ", " + String.valueOf(d));
		
		// 암묵적 변환
		System.out.println(a + "," + b + "," + c + "," + d); // 문자열이 들어가면 나머지 변수들도 자동으로 문자열로 변환
		
		// byte[], char[] : 문자열을 배열로 변환
		byte[] byteStr1 = str1.getBytes();
		byte[] byteStr2 = str2.getBytes(Charset.defaultCharset());
		System.out.println(Arrays.toString(byteStr1));
		System.out.println(Arrays.toString(byteStr2)); // 한글은 utf-8 기준 초성 중성 종성으로 나눠서 나옴
		System.out.println(Arrays.toString(str2.toCharArray())); // 한 글자씩 내기
		
		
		
		
		// 5. equals() : 문자열 내용 비교
		// ※ 문자열 비교 시 == 같은 기존 비교 연산자는 사용 불가
		System.out.println(str1.equals("Hello World"));
		System.out.println(str1.equalsIgnoreCase("hello java!")); // 대소문자 구분 안 함
		
		
	}

}
