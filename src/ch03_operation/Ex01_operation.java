package ch03_operation;

public class Ex01_operation {

	public static void main(String[] args) {
		int i = 2, k = 3;
		
		double n = (double) k / i; // 한 쪽을 double로 해야 나누기 결과가 double이 됨
		System.out.printf("%.1f, %d, %d\n", n, i++, --k); // 1.5, 2, 2
		
		char c = '안';
		System.out.println(c == '안'); // == 은 primitive 자료형 (값이 직접적으로 들어가는 자료형)만 사용 가능
		
		/*
		 * 참조 자료형 : 데이터 자체가 아닌 데이터가 있는 위치를 저장하는 형태의 자료형
		 * 배열, 문자열(String) 등이 해당
		 * 
		 * 참조 자료형은 데이터가 있는 위치만 저장하므로
		 * == 같은 직접적인 비교 연산자 사용 시 원하는 결과가 나오지 않을 수 있음
		 */
		
		String h = "Hello";
		System.out.println(h == "Hello"); // 일단은 같은 주소를 비교하므로 True가 뜸
		
		String s = new String("Hello"); //참조 자료형 String 생성
		System.out.println(s == "Hello"); // 에러는 나지 않지만 false가 뜸
		System.out.println(s.equals("Hello")); // 참조 자료형 비교 시 equals 메소드 사용해야 안전
		
		
		/*
		 * 비교연산자 : &&, ||, ==
		 * 
		 * short가 적용되기에 &&, || 연산 시 앞의 논리식만으로 결론이 나면 뒤의 논리식은 무시
		 * ex) a == b && a / 0 == 1  계산 시 a == b가 false면 a / 0 은 계산하지 않음 
		 */
		
		
		
		// 삼항연산자 ? : javascript, C언어와 사용법 동일
		// 성적이 70점 이상이면 합격, 그렇지 않으면 불합격
		int point = (int) ( 61 * Math.random() ) + 40; // 40 ~ 100 점 중 랜덤 생성
		char grade = point >= 70 ? '급' : '낙';
		System.out.printf("%d : %c%n", point, grade);
	}

}
