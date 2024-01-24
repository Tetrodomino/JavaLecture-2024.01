package ch17_collection_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex04_Perfomance {
	public static void main(String[] args) {
		List<String> al = new ArrayList<String>();
		List<String> ll = new LinkedList<String>();
		
		// ArrayList 맨 앞에 100000회 삽입하는 경우의 시간 구하기
		long startTime = System.nanoTime(); // 시스템의 시간 대입
		
		for (int i = 1; i <= 100000; i++)
			al.add(0, String.valueOf(i));
		
		long endTime = System.nanoTime();
		
		System.out.println("ArrayList 소요시간: " + (endTime - startTime) + "ns");

		// LinkedList 맨 앞에 100000회 삽입하는 경우의 시간 구하기
		startTime = System.nanoTime(); // 시스템의 시간 대입
		
		for (int i = 1; i <= 100000; i++)
			ll.add(0, String.valueOf(i));
		
		endTime = System.nanoTime();
		
		System.out.println("LinkedList 소요시간: " + (endTime - startTime) + "ns");
		System.out.println("===================================================");
		
		
		
		startTime = System.nanoTime(); // 시스템의 시간 대입
		
		for (int i = 1; i <= 100000; i++)
			al.add(String.valueOf(i));
		
		endTime = System.nanoTime();
		
		System.out.println("ArrayList 소요시간: " + (endTime - startTime) + "ns");
		
		// LinkedList 맨 앞에 100000회 삽입하는 경우의 시간 구하기
		startTime = System.nanoTime(); // 시스템의 시간 대입
		
		for (int i = 1; i <= 100000; i++)
			ll.add(String.valueOf(i));
		
		endTime = System.nanoTime();
		
		System.out.println("LinkedList 소요시간: " + (endTime - startTime) + "ns");
		
		
		// 새 요소를 맨 앞에 놓을 때는 linkedlist가 빠르고
		// 맨 뒤에 놓을 때는 ArrayList가 빠름
		
	}
}
