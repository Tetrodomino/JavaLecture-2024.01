package ch10_oop.sec01_person;

public class Main {

	public static void main(String[] args) {
		
		// Person 객체
		Person person = new Person();
		person.name = "제임스";
		person.age = 27;
		
		person.eat(); person.sleep();
		
		// Student 객체
		Student student = new Student();
		student.name = "마리아"; // Person에서 상속받았기에 사용 가능
		student.age = 23;
		student.studentID = 1234;
		
		student.eat(); student.sleep(); student.study(); // 마찬가지로 부모 메소드 사용 가능
		
		// Worker 객체
		Worker worker = new Worker();
		worker.name = "브라이언";
		worker.age = 32;
		worker.workerID = 9876;
		
		worker.eat(); worker.sleep(); worker.work();
	}

}
