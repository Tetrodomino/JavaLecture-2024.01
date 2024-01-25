package ch17_collection.part3_map;

import java.util.HashMap;
import java.util.Map;

import ch17_collection.part2_set.sec02_member.Member;

public class Ex03_MemberTreeMap2 {
	public static void main(String[] args) {
		
		Map<Integer, Member>  map = new HashMap<>();
		
		map.put(101, new Member(21, "james"));
		map.put(101, new Member(24, "maria"));
		map.put(101, new Member(29, "brian"));
		
		
		Map<Member, Integer> map2 = new HashMap<Member, Integer>();
		map2.put(new Member(21, "james"), 100000);
		map2.put(new Member(24, "maria"), 300000);
		map2.put(new Member(29, "brian"), 150000);
		
		map2.forEach((k, v) -> System.out.println(k + ": " + v));
	}
}
