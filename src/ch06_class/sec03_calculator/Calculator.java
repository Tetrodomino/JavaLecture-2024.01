package ch06_class.sec03_calculator;

public class Calculator {
	public int add(int x, int y) {
		return x + y;
	}
	
	// 메소드 오버로딩 (반환 타입이나 매개변수가 다르고 이름만 같은 메소드 생성)
	public double add(double x, double y) {
		return x + y;
	}
	
	public int sub(int x, int y) {
		return x - y;
	}
	
	public int mul(int x, int y) {
		return x * y;
	}
	
	public double div(int x, int y) {
		return (double) x / y;
	}
	
	public void print(int x, int y) {
		System.out.println(x + " + " + y + " = " + add(3, 4));
		System.out.println(x + " × " + y + " = " + mul(x, y));
		System.out.println(x + " - " + y + " = " + sub(x, y));
		System.out.println(x + " ÷ " + y + " = " + div(x, y));
	}
}
