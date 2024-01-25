package ch17_collection.part2_set;

import java.util.HashSet;
import java.util.Set;

public class Ex01_HashSet {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		// 데이터 추가
		set.add("Java");
		set.add("collection");
		set.add("set");
		System.out.println(set);
		
		set.add("set");
		System.out.println(set); // Set(집합) 자료구조는 데이터의 중복 저장이 되지 않음
		
		// 데이터 삭제
		set.remove("set");
		System.out.println(set); // set이 삭제됨
		
		set.clear(); // 전부 삭제
		System.out.println(set + ", " + set.isEmpty());
		
		// 데이터 추출
		set.add("Java");
		set.add("collection");
		set.add("set");
		
		System.out.println(set.size()); // 데이터의 개수
		System.out.println(set.contains("Java")); // 해당 데이터의 존재 여부
		
		// 모든 객체 꺼내기
		for (String s: set)
		{
			System.out.println(s);
		}
		
		
		
		// 정수형 집합 생성
		Set<Integer> intSet = new HashSet<Integer>(); // HashSet 쪽에 있는 Integer는 생략 가능
		
		intSet.add(1);
		intSet.add(3);
		intSet.add(6);
		intSet.add(9);
		intSet.add(12);
		
		
		
	}
}
