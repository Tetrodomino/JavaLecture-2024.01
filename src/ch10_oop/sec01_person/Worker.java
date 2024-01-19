package ch10_oop.sec01_person;

public class Worker extends Person {

	int workerID;
	
	void work() {
		System.out.println(name + "이(가) 일을 합니다");
	}
}
