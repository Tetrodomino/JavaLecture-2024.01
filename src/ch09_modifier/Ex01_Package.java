package ch09_modifier;

// 다른 패키지의 클래스 호출
import ch06_class.sec01_member.*; //.*은 하위 모든 클래스를 임포트한다는 의미
import ch06_class.sec05_Melon.*;

public class Ex01_Package {

	public static void main(String[] args) {

		Member member = new Member();
		Interpark interbook = new Interpark();
	}

}