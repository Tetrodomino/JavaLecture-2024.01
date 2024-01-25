package ch17_collection.part1_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex02_ArrayList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		ArrayList<String> aList = new ArrayList<>(); // 이 방식으로는 잘 안 쓰임
		
		list.add("class"); list.add("interface"); list.add("inheritance");
		System.out.println(list);
		
		// 정적 리스트
		List<String> fruitList = Arrays.asList(new String[] {"apple", "banana", "cherry"}); 
		System.out.println(fruitList);
		//fruitList.add("mango");  // 단, 이렇게 만들면 이런 방식으로 추가는 불가
		
		
		// primitive 타입은 wrapper 클래스로 리스트 생성해야 함
		List<Integer> numList = new ArrayList<>();
		numList.add(1); 
		numList.add(3); 
		numList.add(5); 
		
		System.out.println(numList);
		
		
		// 추출(인덱싱)
		System.out.println(list.get(0));	// list의 0번째 데이터 출력
		
		list.add("list");			// 맨 뒤에 추가
		list.add(3, "collection"); 	// 3번째 자리에 추가
		System.out.println(list);
		
		list.addAll(fruitList); // 맨 뒤에 컬렉션(리스트)을 추가
		System.out.println(list);
		
		// 데이터 변경
		list.set(5, "set"); // 5번째 자리의 값을 set으로 변경
		System.out.println(list);
		
		// 데이터 삭제
		list.remove(6); // 6번째 값 삭제
		list.remove("cherry"); // cherry가 있으면 가장 처음 나오는 값 삭제
		System.out.println(list);
		
		List<String> list2 = new ArrayList<>();
		list2.add("a");
		list2.add("b");
		list2.add("c");
		
		list2.clear(); // list2의 전체 원소 삭제
		System.out.println(list2 + ", " + list2.size()); // 비어있는지 확인
		
		// 정보 추출
		System.out.println(numList.contains(3)); // 3이 들어있는지 확인
		
		System.out.println(list.contains("set") + "," + list.indexOf("list")); // set이 포함된지 여부와 list 요소의 위치
		// indexOf에서 없을 경우 -1을 리턴
	}

}
