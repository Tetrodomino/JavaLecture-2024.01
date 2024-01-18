package ch06_class.sec01_member;

import java.time.LocalDate;

public class Member {
	//────────────────────────────────────────────────────────────────────────────────────────────────────────//
	// 필드, 멤버
	public String name;
	private LocalDate birthday;
	private String email;
	//────────────────────────────────────────────────────────────────────────────────────────────────────────//
	
	
	//────────────────────────────────────────────────────────────────────────────────────────────────────────//
	// 생성자(construtor)
	public Member() {}
	
	public Member(String name, LocalDate birthday, String email) {
		this.name = name;
		this.birthday = birthday;
		this.email = email;
	}
	//────────────────────────────────────────────────────────────────────────────────────────────────────────//


	//────────────────────────────────────────────────────────────────────────────────────────────────────────//
	// 메소드(Method)
	public int getAge() {
		LocalDate today = LocalDate.now();
		
		int year = today.getYear();			// 연
		int month = today.getMonthValue();	// 월
		int day = today.getDayOfMonth();	// 일
		
		int age = 0;
		
		age = year - birthday.getYear();
		
		if (birthday.getMonthValue() > month)
			age--;
		else if (birthday.getMonthValue() == month && birthday.getDayOfMonth() > day)
			age--;
		return age;
	}

	@Override
	public String toString() {
		return "member [name=" + name + ", birthday=" + birthday + ", email=" + email + "]";
	}
	
	
	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	//────────────────────────────────────────────────────────────────────────────────────────────────────────//



	// 내부 클래스
	class InnerClass {
		
	}
}

// 외부 클래스
// 접근제한자를 쓰지 않아 default
class ExternalClass {
	
}