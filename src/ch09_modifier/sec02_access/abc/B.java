package ch09_modifier.sec02_access.abc;

public class B {
	
	void abc() {
		A a = new A();

		System.out.println(a.a + a.b + a.c /*+ a.d*/); // d는 private라 쓸 수 없음
	}
}
