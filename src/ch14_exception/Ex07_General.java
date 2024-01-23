package ch14_exception;

public class Ex07_General {
	public static void main(String[] args) {
		int value = 0;
		
		// 2가지 오류를 함께 처리하기 - | 사용
		try {
			value = Integer.parseInt(args[0]);
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) { // Ex05에 있던 두 가지 catch를 하나로 합침
			e.printStackTrace();
			System.out.println("매개변수가 필요하고 숫자를 입력해야 합니다");
		}
		
		System.out.println(value);
	}
}
