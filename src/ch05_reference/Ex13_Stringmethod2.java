package ch05_reference;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Ex13_Stringmethod2 {
	public static void main(String[] args) {
		
		String str1 = "Hello Java";
		String str2 = "안녕하세요? 반갑습니다.";
		
		// 1. 대소문자 변경 메소드 toUpperCase() : 대문자로 변경
		System.out.println(str1.toUpperCase());
		
		
		
		// 2. replace(a, b) : a 문자열을 b로 대체
		// ※ 적용한 문자열 자체는 변경되지 않고 새 문자열에 대입하던가 해서 사용
		String str2_1 = str2.replace("안녕하세요", "안녕").replace("반갑습니다", "방가방가");
		System.out.println(str2_1);
		
		// 적용되는 문자열이 여러 개 있으면 모두 변경
		System.out.println(str2_1.replace("방가", "하이"));
		
		// 2-1. 정규식을 사용해서 ?랑 .을 *로 변경
		String regExp = str2.replaceAll("[?.]", "*");
		System.out.println(regExp);
		
		
		
		
		// 3. substring() : 문자열 일부 발췌
		String dateTime = "2024-01-17 14:20:05";
		String date = dateTime.substring(0, 10); // 0번째부터 9번째까지
		String time = dateTime.substring(11); // 11번째부터 끝까지
		System.out.println(date + ", " + time);
		
		// 현재 시간과 날짜 추출하기
		String now = LocalDateTime.now().toString();
		System.out.println(now);
		date = now.substring(0, 10);
		time = now.substring(11, 19);
		System.out.println(date);
		
		// 주민등록번호로부터 생년월일 표시하기
		String ssn1 = "880927-1234567", ssn2 = "010117-4123456";
		System.out.println(birth(ssn1) + ", " + birth(ssn2));
		
		
		
		
		// 4. split() : 문자열을 분할해서 배열로 반환
		String fruitStr = "감, 배, 귤, 밤";
		String[] fruits = fruitStr.split(", "); // ", " 을 기준으로 분할
		System.out.println(Arrays.toString(fruits));
		
		// 정규식을 이용해서 분할
		fruitStr = "감, 배; 귤: 밤";
		fruits = fruitStr.split("[,;:]"); // , 또는 ; 또는 : 로 분할
		System.out.println(Arrays.toString(fruits));
		
		// 파일 경로 분할
		String path = "C:\\Program Files\\Common Files\\Oracle\\Java\\javapath;C:\\WINDOWS\\system32;C:\\WINDOWS;C:\\WINDOWS\\System32\\Wbem;C:\\WINDOWS\\System32\\WindowsPowerShell\\v1.0\\;C:\\WINDOWS\\System32\\OpenSSH\\;C:\\Program Files\\Bandizip\\;C:\\Program Files\\Git\\cmd;C:\\Program Files\\nodejs\\;C:\\Users\\human-15\\AppData\\Local\\Programs\\Python\\Launcher\\;C:\\Users\\human-15\\AppData\\Local\\Microsoft\\WindowsApps;;C:\\Users\\human-15\\AppData\\Local\\Programs\\Microsoft VS Code\\bin;C:\\Users\\human-15\\AppData\\Roaming\\npm";
		String[] pathArray = path.split(";");
		for (String path2: pathArray)
		{
			System.out.println(path2.replace("\\", "/"));
		}
		
		
		
		
		// 5. join(a, s) : 문자열 배열을 하나의 문자열로 통합. 각 항목의 사이는 a로 이어짐
		System.out.println(String.join(" -:- ", fruits));
		
		
		
		// 6. trim() : 문자열 좌우의 공백 제거
		String dirtyText = " \t 자바 프로그래밍    \t \r\n";
		String cleanText = dirtyText.trim();
		System.out.println(cleanText + ", " + cleanText.length());
		
	}
	
	static String birth(String s) {
		
		String year;
		
		if (s.charAt(7) == '1' || s.charAt(7) == '2')
			year = "19";
		else
			year = "20";
		
		year += s.substring(0, 2);
		String month = s.substring(2, 4);
		String day = s.substring(4, 6);
		
		String s2 = year + "-" + month + "-" + day;
		return s2;
	}
}
