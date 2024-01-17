package ch04_control;

public class Ex99_example {
	
	/************     4장 연습 문제      ************/

	public static void main(String[] args) {
		
		Example5();
	}
	
	static void Example1() {
		
		int score = (int) (Math.random() * 150);
		
		if (score > 100) score -= 50;
		
		System.out.println(score);
				
		if (score >= 80 && score < 90)
			System.out.println("B학점");
		else if (score >= 90)
			System.out.println("A학점");
		else if (score >= 70 && score < 80)
			System.out.println("C학점");
		else
			System.out.println("F학점");
	}
	
	
	static void Example2() {
		int score = (int) (Math.random() * 150);
		
		if (score > 100) score -= 50;
		
		System.out.println(score);
		
		switch (score / 10) {
		case 10:
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		default:
			System.out.println("F학점");
		}
	}
	
	
	static void Example3() {
		for (int i = 0; ; i++)
		{
			if (i % 2 == 1)
				continue;
			
			if (i > 10)
				break;
			
			System.out.println(i);
		}
	}
	
	static void Example4() {
		int i = 10;
		
		while (i > 0)
		{
			System.out.println(i);
			i -= 2;
		}
	}
	
	static void Example5 () {
		int count = 0;
		
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (i == 2)
					continue;
				
				if (j == 1)
					break;
				System.out.println("A");
				count++;
			}
		}
		
		System.out.println(count + "회");
	}

}
