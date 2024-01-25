package ch17_collection.part1_list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex11_Sort {

	public static void main(String[] args) {

		List<Integer> scoreList = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++)
		{
			int score = (int) (Math.random() * 100);
			scoreList.add(score);
		}
		
		System.out.println("============정렬없음============");
		System.out.println(scoreList);
		System.out.println("============오름차순============");
		scoreList.sort(Comparator.naturalOrder());
		System.out.println(scoreList);
		System.out.println("============내림차순============");
		scoreList.sort(Comparator.reverseOrder());
		System.out.println(scoreList);
		
		System.out.println();
		
		List<String> fruits = new ArrayList<String>();
		
		fruits.add("밤");
		fruits.add("감");
		fruits.add("사과");
		fruits.add("배");
		fruits.add("포도");
		fruits.add("복숭아");
		
		// 한글은 ㄱㄴㄷ 순으로 정렬
		System.out.println("============정렬없음============");
		System.out.println(fruits);
		System.out.println("============오름차순============");
		fruits.sort(Comparator.naturalOrder());
		System.out.println(fruits);
		System.out.println("============내림차순============");
		fruits.sort(Comparator.reverseOrder());
		System.out.println(fruits);
	}

}
