package ch17_collection.part2_set;

import java.util.Set;
import java.util.TreeSet;

public class Ex11_TreeSet {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		set.add(10);
		set.add(6);
		set.add(15);
		set.add(20);
		set.add(7);
		
		System.out.println(set); // 자동으로 정렬이 됨
		
		Set<String> strSet = new TreeSet<String>();
		
		strSet.add("a");
		strSet.add("e");
		strSet.add("z");
		strSet.add("d");
		strSet.add("B");
		strSet.add("k");
		strSet.add("A");
		
		System.out.println(strSet); // 알파벳 역시 정렬
	}
}
