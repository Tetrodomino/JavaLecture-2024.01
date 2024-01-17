package ch05_reference;

// 클래스 만들기 
public class Person {
	
	// 클래스 내의 기본적인 변수
	private String name;
	private int age;
	private String job;
	
	
	// 이하는 이클립스에 Source generation 기능을 이용하여 자동 생성 가능
	public Person() {}
	
	
	public Person(String name, int age, String job) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
	}


	// print 등으로 출력시키려 할 때 자동으로 String으로 변환시켜서 출력해주는 toString
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", job=" + job + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}

	
}
