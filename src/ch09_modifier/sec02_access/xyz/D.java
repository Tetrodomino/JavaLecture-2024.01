package ch09_modifier.sec02_access.xyz;

import ch09_modifier.sec02_access.abc.A;

public class D extends A { // A를 상속받은 클래스 D

	void xyz() {
		
		System.out.println(a + b); // 상속을 받았으므로 A 클래스의 a, b 사용 가능, c, d는 사용 불가
	}
}
