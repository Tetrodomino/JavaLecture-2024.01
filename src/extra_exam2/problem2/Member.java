package extra_exam2.problem2;

import java.time.LocalDate;

public class Member {
	private int mid;
	private String name;
	private int birthYear;
	private String tel;
	
	public Member() {}
	
	public Member(int mid, String name, int birthYear, String tel) {
		this.mid = mid;
		this.name = name;
		this.birthYear = birthYear;
		this.tel = tel;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		int nowYear = LocalDate.now().getYear();
		
		return "Id: " + mid + ", 이름: " + name + ", 나이: " + (nowYear - birthYear) + ", 전화번호: " + tel;
	}
	
	
}
