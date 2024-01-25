package ch17_collection.part3_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Ex01_HashMap {

	public static void main(String[] args) {

		// Map : Key와 Value의 쌍으로 이루어진 자료구조
		// Key는 통상 String이 들어각 Value는 들어가는 자료형에 제한 없음
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// 데이터 추가
		map.put("사과", 1500);
		map.put("배", 2500);
		map.put("감", 1000);

		System.out.println(map);

		map.put("배", 3000);
		System.out.println(map); // 이미 있는 키의 값을 넣으면 해당 키의 값이 갱신됨
		
		System.out.println("-----------------------------------------");
		
		// 데이터 추출
		System.out.println(map.get("사과")); // value 값을 추출
		
		// 정보 추출
		System.out.println(map.containsKey("배")); // "배" 에 해당하는 key가 있으면 true
		System.out.println(map.containsValue(4000)); // 4000에 해당하는 value가 있으면 true;
		
		System.out.println("-----------------------------------------");
		
		// key의 set collection
		Set<String> keySet = map.keySet(); // key 값만 가지는 Set(집합) 생성
		
		// 생성한 집합을 통해 map의 항목 출력
		for (String key: keySet) // keySet 대신 map.keySet() 넣어도 작동
		{
			System.out.println(key + ": " + map.get(key));
		}
		
		System.out.println("-----------------------------------------");
		
		// Entry의 Set collection
		Set<Entry<String, Integer>> entry = map.entrySet();
		
		for(Entry<String, Integer> ent: entry)
			System.out.println(ent.getKey() + ": " + ent.getValue());
		
		// Stream으로 처리 
		map.forEach((k, v) -> System.out.println(k + ": " + v));
		System.out.println("-----------------------------------------");
		
		
		// 데이터 삭제
		map.remove("감");
		System.out.println(map.size()); // 1개 줄어듬
		map.forEach((k, v) -> System.out.println(k + ": " + v));
	}
	
	

}
