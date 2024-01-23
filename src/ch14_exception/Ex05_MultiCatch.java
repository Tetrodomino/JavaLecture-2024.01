package ch14_exception;

public class Ex05_MultiCatch {
	public static void main(String[] args) {
		int value = 0;
		
		// 2가지 오류를 함께 처리하기 - catch를 두 개 사용
		try {
			value = Integer.parseInt(args[0]);
		} catch (ArrayIndexOutOfBoundsException e) { // args에 아무것도 입력하지 않을 경우
			e.printStackTrace();
			System.out.println("매개변수를 입력해야 합니다");
		} catch (NumberFormatException e) { // args에 숫자가 아닌 문자가 있을 경우
			e.printStackTrace();
			System.out.println("올바른 숫자를 입력해야 합니다");
		}
		System.out.println(value);
	}
}
