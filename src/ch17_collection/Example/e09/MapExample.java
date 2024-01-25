package ch17_collection.Example.e09;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		
		for (String key: map.keySet())
		{
			if (map.get(key) > maxScore)
			{
				name = key;
				maxScore = map.get(key);
			}
			
			totalScore += map.get(key);
		}
		
		System.out.println("평균점수: " + (int) (totalScore / map.size()));
		System.out.println("최고점수: " + maxScore);
		System.out.println("최고점수를 받은 아이디: " + name);
	}

}
