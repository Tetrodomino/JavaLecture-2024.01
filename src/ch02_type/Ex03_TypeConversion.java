package ch02_type;

public class Ex03_TypeConversion {
	
	public static void main(String[] args) {
		/*
		 * 자동 형변환 (Promotion) : 작은 자료형에서 큰 것으로 갈 경우
		 * 
		 * byte → short → int → long → float → double → string
		 * 
		 * 뒤로 갈수록 우선 순위가 높아짐
		 */
		
		short a = 256;
		int b = a;
		long c = b;
		float d = c;
		double e = d;
		
		System.out.printf("%d, %d, %d, %.1f, %.1f %n", a, b, c, d, e); // d와 e는 각각 float나 double 자료형으로 출력
		
		
		/*
		 * 강제 형변환 (Casting) : 큰 자료형에서 작은 것으로 갈 경우 필요, 단 작은 자료형의 범위를 초과하는 값은 불가능
		 */
		
		long f = 250l;
		int g = (int) f;
		short h = (short) g;
		
		double i = 3.14;
		float j = (float) i;
		
		System.out.printf("%d, %d, %d, %.1f, %.1f %n", f, g, h, i, j);
		System.out.println("(int) i: " + (int)i);
		
		
		/*
		 * 연산을 통한 자동 형변환
		 */
		long k = a + b + c; // 제일 크기가 큰 long 쪽으로 형변환
		double l = d + e; // 제일 크기가 큰 double 쪽으로 형변환
		double m = a / b; // int / int는 기본적으로 int가 되어 소숫점이 잘림
		
		System.out.println("k: " + k + ", l: " + l + ", m: " + m);
	}
}
