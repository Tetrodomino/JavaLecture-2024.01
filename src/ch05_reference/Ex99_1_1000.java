package ch05_reference;

import java.util.Arrays;

public class Ex99_1_1000 {
	public static void main(String[] args) {
		
		// 1 ~ 1000까지 각 숫자가 얼마나 나오는지 구하기
		String num = "";
		
		for (int i = 1; i <= 1000; i++)
		{
			num += i;
		}
		
		for (int i = 0; i <= 9; i++)
		{
			String inum = num.replaceAll("[^" + i + "]", "");
			System.out.println(i + ": " + inum.length() +"회");
		}
		
		
		// 배열을 사용
		int[] count = new int[10];
		for (int i = 0; i < num.length(); i++)
		{
			char n = num.charAt(i);
			int numValue = n - '0';
			count[numValue]++;
		}
		
		System.out.println(Arrays.toString(count));
	}
}
