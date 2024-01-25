package ch17_collection.part2_set.sec12_member;

public class member implements Comparable {
	private int age;
	private String name;
	
	public member() {}
	
	public member(int age, String name) {
		this.age = age;
		this.name = name;
	}

	// TreeSet이나 TreeMap에 사용되는 객체는 Comparable I/F를 구현해야 함
	@Override
	public int compareTo(Object o) {
		if (o instanceof member)
		{
			member m = (member) o;
			
			// 이름만 가지고 비교
//			return this.name.compareTo(m.getName());
			
			// 이름으로 먼저 비교하고 같으면 나이의 역순으로 배치
			if (this.name.compareTo(m.getName()) == 0)
				return m.getAge() - this.age;
			else
				return this.name.compareTo(m.getName());
		}
		else
			return 0;
	}
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "member [age=" + age + ", name=" + name + "]";
	}
	
}
