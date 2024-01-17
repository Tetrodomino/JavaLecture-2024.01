package ch05_reference;

public class Ex99_palidrome {
	public static void main(String[] args) {
		
		String numStr = "";
		int max = 0;
		
		for (int i = 0; i <= 999; i++)
		{
			for (int j = i; j <= 999; j++)
			{
				int c = i * j;
				
				if (isPal(String.valueOf(c)) && max < c)
				{	
					max = c;
					numStr = i + " × " + j + " = " + c; 
				}
			}
		}
		
		System.out.println(numStr);
	}
	
	static boolean isPal(String num) {
		
		String dum = "";
		
		for (int i = num.length() - 1; i >= 0; i--)
		{
			dum += String.valueOf(num.charAt(i)) + "";
		}
		
		if (num.equals(dum))
			return true;
		//if (Integer.parseInt(dum) == Integer.parseInt(num))
		//	return true;
		
		return false;
	}
}
