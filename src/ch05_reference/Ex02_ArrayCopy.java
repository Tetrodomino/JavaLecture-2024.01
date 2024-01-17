package ch05_reference;

import java.util.Arrays;

public class Ex02_ArrayCopy {

	public static void main(String[] args) {
		
		int src[] = { 1, 2, 4, 8};
		
		int[] dst = src; // 다른 배열을 대입하는 방법
		
		System.out.println(Arrays.toString(dst));
		
		dst[2] = 5;
		System.out.println(Arrays.toString(dst));
		System.out.println(Arrays.toString(src)); // dst의 값만 바꿨는데 src의 값도 변경됨
		
		
		// 배열만 복사시키는 법
		int[] newSrc = {3, 4, 7, 9};
		int[] newDst = new int[4];
		System.arraycopy(newSrc, 0, newDst, 0, newSrc.length); // arraycopy 사용
		// arraycopy 같은 것을 Deep copy라 하는데 2차원 배열부터는 불가능
		
		System.out.println(Arrays.toString(newDst));
		
		newDst[2] = 15;
		System.out.println(Arrays.toString(newDst));
		System.out.println(Arrays.toString(newSrc)); // 이젠 두 배열이 달라짐
	}

}
