package extra_exam2;

public class problem1 {

	public static void main(String[] args) {

		// 1-1
		int sum = 0;
		
		for (int i = 1; i <= 100; i++)
		{
			if (i % 3 == 0)
				sum += i;
		}
		System.out.println(sum);
		
		
		// 1-2
		sum = 0;
		for (int i = 1; i <= 20; i++)
		{
			if (i % 2 == 1)
				sum += i * i;
		}
		System.out.println(sum);
		
		
		// 1-4
		sum = 0;
		for (int i = 2; i <= 100; i++)
		{
			if (isPrime(i))
				sum += i;
		}
		System.out.println(sum);
	}
	
	// 1-3
	public static boolean isPrime(int a) {
		
		if (a <= 1)
			return false;
		
		for (int i = 2; i <= a / 2; i++)
		{
			if (a % i == 0)
				return false;
		}
		
		return true;
	}

}
