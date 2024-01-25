package ch17_collection.Example.e10;

public class Student implements Comparable {

	public String id;
	public int score;
	
	public Student(String id, int score) {
		this.id = id;
		this.score = score;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Student)
		{
			Student m = (Student) o;
			
			return this.score - m.score;
		}
		else
			return 0;
	}
}
