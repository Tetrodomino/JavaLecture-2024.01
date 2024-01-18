package ch06_class.sec03_calculator;

public class CalculatorMain {

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		System.out.println(calc.add(3, 4));
		
		int x = 3, y = 4;
		System.out.println(calc.mul(x, y));
		System.out.println(calc.sub(x, y));
		System.out.println(calc.div(x, y));
		
		calc.print(25, 20);
		
		System.out.println("3.1 + 4.5 = " + calc.add(3.1, 4.5));
	}

}
