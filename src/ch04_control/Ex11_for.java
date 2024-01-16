package ch04_control;

import java.util.Scanner;

public class Ex11_for {

	public static void main(String[] args) {
		// 1에서부터 1000까지 합
		
		int sum = 0;
		
		for (int i = 1; i <= 1000; i++)
		{
			sum += i;
		}
		
		System.out.println(sum);
		
		
		//1에서 1000까지 홀수 합
		sum = 0;
		for (int i = 1; i <= 1000; i += 2)
		{
			sum += i;
		}
		System.out.println(sum);
		
		
		//진약수의 합
		Scanner scan = new Scanner(System.in);
//		
//		System.out.print("자연수 입력: ");
//		int num = Integer.parseInt(scan.nextLine());
//		
//		sum = 0;
//		for (int i = 1; i <= num / 2; i++)
//		{
//			if (num % i == 0)
//				sum += i;
//		}
//		System.out.println(sum);
		
		
		// 초기식, 증감식에 여러개의 변수 사용 가능
		sum = 0;
		for (int i=1,k=2; i * k < 100; i++, k++)
		{
			System.out.println(i + k);
		}
		
		
		// 사용자가 5번 입력한 문자열을 받아서 공백을 사이에 넣고 하나의 문자열로 만들어서 출력
//		String s = "";
//		
//		for (int i = 0; i < 5; i++)
//		{
//			System.out.print("문자열 입력: ");
//			s += scan.nextLine() + " ";
//		}
//		
//		System.out.println(s);
		scan.close();
		
		
		// 배열 선언
		String[] fruits = {"apple", "banana", "pineapple"};
		
		for (String f: fruits) // 배열 항목을 for로 돌리는 법
		{
			System.out.println(f);
		}
	}

}
