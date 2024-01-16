package ch04_control;

public class Ex14_perfectnumber {
	public static void main(String[] args) {
		
		for (int i = 1; i <= 10000; i++)
		{
			int sum = perfectnum(i);
			
			if (sum == i)
				System.out.println(i);
		}
	}
	
	// 메소드 만들기
	// main에 static이 붙었으므로 메소드도 static이 필요
	static int perfectnum(int num) {
		
		int sum = 0;
		for (int j = 1; j <= num / 2; j++)
		{
			if (num % j == 0)
				sum += j;
		}

		return sum;
	}
}
