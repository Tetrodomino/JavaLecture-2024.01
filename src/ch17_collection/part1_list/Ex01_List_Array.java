package ch17_collection.part1_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex01_List_Array {

	public static void main(String[] args) {
		String[] array = "가나다라마바사".split("");
		System.out.println(Arrays.toString(array));
		
		List<String> list = new ArrayList<String>(); 
		list = new ArrayList<>();  // 구현객체(ArrayList)에 있는 String 부분은 생략 가능
		for (int i = 0; i < array.length; i++)
		{
			list.add(array[i]);
		}
		
		
		
		// 리스트 출력하기
		for (String e: list) // 하나 하나 출력
		{
			System.out.print(e + " ");
		}
		System.out.println();
		
		list.forEach(x -> System.out.print(x + " ")); // 하나 하나 출력 2
		
		System.out.println();
		
		
		
		// 배열의 항목 삭제
		array[2] = null; array[5] = null;
		System.out.println(Arrays.toString(array));
		
		// 리스트의 항목 삭제
		// 배열과 달리 null로 남은 곳이 없음
		list.remove("다"); list.remove("바");
		System.out.println(list);
		
		// 삭제 후 크기 비교
		// 배열은 7, 리스트는 5
		System.out.println(array.length + ", "+ list.size());
		
		
		
		// 추가(삽입)
		// 배열은 불가능하고 리스트만 가능
		list.add("아"); 
		list.add("자"); 
		list.add("차"); 
		System.out.println(list);
	}

}
