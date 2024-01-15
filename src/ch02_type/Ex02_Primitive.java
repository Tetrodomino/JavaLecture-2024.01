package ch02_type;

public class Ex02_Primitive {

	public static void main(String[] args) {
		
		// boolean 타입
		boolean a = true, b = false;
		
		System.out.println("a: " + a + ", b: " + b);
		
		
		/*
		 * 정수 계열 자료형
		 * 
		 *    명칭	   크기   	   범위
		 * 1. byte	: 1바이트 :	-128 ~ 127
		 * 2. short	: 2바이트 :	-32768 ~ 32767
		 * 3. int	: 4바이트 :	-2147483648 ~ 2147483647
		 * 4. long	: 8바이트 :	-2^63 ~ 2^63-1
		 * 
		 * ※ 그냥 숫자만 입력(-123, 45 등)한 것은 기본적으로 int 타입
		 * ※ long 타입 숫자값 뒤에는 l 을 붙여야 함 (15l 등)
		 */
		
		byte c = 10;
		short d = 1024;
		int e = 20000000;
		long f = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 * 16l; //l을 붙여야 long으로 취급
		
		System.out.printf("%d, %d, %d, %d\n", c, d, e, f);
		
		
		/*
		 * 실수 계열 자료형
		 * 
		 *    명칭	   	   크기   	   유효자리
		 * 1. float 	: 4바이트 :	소숫점 이하 7자리
		 * 2. double 	: 8바이트 :	소숫점 이하 15자리
		 * 
		 * ※ 실수값(3.14, 2.7 등)은 기본적으로 double 타입
		 * ※ float 타입의 값 뒤에는 f를 붙여야 함
		 */
		
		float f1 = 1.0000001f, f2 = 1.00000001f; // 각각 7자리 8자리
		double d1 = 1.000000000000001, d2 = 1.0000000000000001; // 각각 15자리 16자리
		
		System.out.println("f1: " + f1 + ", f2: " + f2);
		System.out.println("d1: " + d1 + ", d2: " + d2);
		
		
		/*
		 * 문자(글자 1개) 자료형
		 */
		char eng = 'A'; 	// 작은 따옴표만 허용
		char kor = '안';
		System.out.println("eng: " + eng + ", kor: " + kor);
	}

}
