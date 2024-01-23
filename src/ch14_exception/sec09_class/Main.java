package ch14_exception.sec09_class;

public class Main {

	public static void main(String[] args) throws MyException {
		MyException me1 = new MyException();
		MyException me2 = new MyException("내가 만든 예외 클래스");
		
		//throw me1;
		//throw me2; // 에러 문구에 "내가 만든 예외 클래스"가 붙음
		//throw new MyException("의도적 예외 발생"); // 의도적 예외 발생이 에러 문구에 붙음
		
//		throw new MyRunTimeException("의도적 런타임 에러 발생");
		
		
		// 일단 에러가 발생하면 실행이 중지되므로 루프를 탈출할 때 사용 가능
		try {
			for (int i = 0; i <= 100000; i++)
			{
				for (int k = 0; k <= 1000000; k++)
				{
					if (i == 100 && k == 100)
						throw new MyException("100 100에서 강제 종료");
				}
			}			
		} catch (MyException e) {
			e.printStackTrace();
		}
		
		System.out.println("이중 루프 탈출");
	}

}
