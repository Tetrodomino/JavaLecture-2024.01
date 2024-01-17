package ch05_reference;

import java.util.Arrays;

public class Ex01_array {

	public static void main(String[] args) {
		
		// 배열을 생성하면서 값을 지정하는 경우
		int[] score = {80, 90, 78, 93, 65};
		
		char grade[] = {'B', 'A', 'C', 'A', 'D'};
		
		
		// 배열을 생성하면서 크기 지정
		int[] newArray = new int[10]; // 10개의 정수값을 갖는 배열 생성
	
		// 한 번 선언한 배열은 크기 변경 불가
		
		
		
		// 배열 인덱싱
		System.out.println(score[0] + ", " + score[4]); // 1번째와 5번째 값
		for (int i = 0; i < score.length; i++)
		{
			System.out.print(score[i] + " ");
		}
		System.out.println();
		
		// 값 할당
		score[0] = 90; grade[0] = 'A';
		for (int i = 0; i < newArray.length; i++)
		{
			newArray[i] = 1 + (int) (Math.random() * 6);
		}
		System.out.println(Arrays.toString(newArray)); // 배열을 스트링의 형식으로 바꿔서 출력
		System.out.println(Arrays.toString(score));
	}

}
