package ch17_collection.part2_set.sec12_member;

import java.util.Set;
import java.util.TreeSet;

public class memberTreesetMain {

	public static void main(String[] args) {

		Set<member> set = new TreeSet<member>();
		
		set.add(new member(21, "james"));
		set.add(new member(20, "maria"));
		set.add(new member(25, "james"));
		
		System.out.println(set);
	}

}
