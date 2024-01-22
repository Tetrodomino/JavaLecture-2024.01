package ch10_oop.sec05_equals;

public class CustomerMain {

	public static void main(String[] args) {
		Customer c1 = new Customer(1001, "제임스", 27, true);
		
		Customer c2 = new Customer(1001, "제임스 브라운", 27, true);
		
		if (c1.equals(c2))
			System.out.println(c1 + "과" + c2+ "는 같습니다.");
		else
			System.out.println(c1 + "과" + c2+ "는 다릅니다.");
		
		// 데이터의 고유한 값이 할당된 해시코드 확인하기
		System.out.println("c1 hashCode: " + c1.hashCode());
		System.out.println("c2 hashCode: " + c2.hashCode());
	}

}
