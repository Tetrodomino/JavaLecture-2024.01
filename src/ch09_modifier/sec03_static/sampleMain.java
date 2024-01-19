package ch09_modifier.sec03_static;

public class sampleMain {

	public static void main(String[] args) {

		Sample sample = new Sample();
		
		
		// 인스턴스 필드, 메소드를 사용하는 방법
		System.out.println(sample.instanceField);
		sample.instanceMethod();
		
		
		// 스태틱 필드, 메소드를 사용하는 방법
		System.out.println(Sample.STATIC_FIELD); // 클래스 자체에서 끌고 오므로 객체를 생성하지 않고 클래스에서 바로 가져옴
		Sample.staticMethod();
	}

}
