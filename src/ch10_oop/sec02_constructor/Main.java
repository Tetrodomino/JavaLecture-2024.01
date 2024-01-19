package ch10_oop.sec02_constructor;

public class Main {

	public static void main(String[] args) {
		
		Person person = new Person("제임스", 27);
		person.eat();
		person.sleep();
		
		// Student 객체
		Student student = new Student("마리아", 23, 1234);
		student.eat();
		student.sleep();
		student.study();
	}
}
