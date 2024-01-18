package ch06_class.sec01_member;

import java.time.LocalDate;

public class memberMain {

	 public static void main(String[] args) {
		 
		 // 객체 생성 (파라메터 없이)
		 Member james = new Member();
		 // 초기 파라메터 값을 주고 객체 생성
		 Member maria = new Member("마리아", LocalDate.of(2003, 1, 19), "maria@gmail.com");
		 
		 
		 // 필드 접근
		 james.name = "제임스"; //접근제한자가 public 이라 직접 변경 가능, private면 바깥에서 직접 변경 불가능
		 james.setEmail("james@naver.com");
		 james.setBirthday(LocalDate.of(2001, 11, 19)); // private 필드는 getter와 setter 메소드를 이용해서 해야함
		 
		 // 메소드 사용
		 System.out.println(james);
		 System.out.println(maria.toString());
		 
		 System.out.println(james.name + ": " + james.getBirthday() + ", " + james.getAge());
		 System.out.println(maria.name + ": " + maria.getBirthday() + ", " + maria.getAge());
	 }
}
