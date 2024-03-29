package ch14_exception;

public class Ex06_MultiCatch2 {
	public static void main(String[] args) {
		int value = 0;
		
		// 모든 기본 오류 처리하기
		try {
			value = Integer.parseInt(args[0]);
		} catch (Exception e) { 		// Exception안에 웬만한 오류는 다 있음
			e.printStackTrace();
			System.out.println("매개변수가 필요하고 숫자를 입력해야 합니다");
		}
		
		System.out.println(value);
	}
}
