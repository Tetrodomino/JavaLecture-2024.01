package ch09_modifier.sec02_access.xyz;

import ch09_modifier.sec02_access.abc.A;

public class C {
	void xyz()
	{
		A a = new A();
		System.out.println(a.a); // 다른 패키지에서 A 클래스를 쓰면 a 변수만 사용 가능
	}
}
