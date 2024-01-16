package ch04_control;

public class Ex12_while {

	public static void main(String[] args) {
		
		// 주사위 눈의 합이 15 이하면 계속 주사위를 굴리고 초과하면 탈출
		int sum = 0;
		int i = 0;
//		
//		while (sum <= 15)
//		{
//			int i1 = 1 + (int) (6 * Math.random());
//			int i2 = 1 + (int) (6 * Math.random());
//			int i3 = 1 + (int) (6 * Math.random());
//			
//			sum = i1 + i2 + i3;
//			System.out.printf("%d: %d (%d, %d, %d)\n", i, sum, i1, i2, i3);
//			i++;		
//		}
//		
		
		// 무한루프를 만들고 탈출 조건을 루프 안에서 만들기
//		sum = 0;
//		while (true)
//		{
//			int i1 = 1 + (int) (6 * Math.random());
//			int i2 = 1 + (int) (6 * Math.random());
//			int i3 = 1 + (int) (6 * Math.random());
//			
//			sum = i1 + i2 + i3;
//			System.out.printf("%d: %d (%d, %d, %d)\n", i, sum, i1, i2, i3);
//			i++;
//			
//			if (sum >= 18)
//				break;
//		}
		
		
		
		// do-while : 한 번은 무조건 실행되는 while
		sum = 17;
		do {
			int i1 = 1 + (int) (6 * Math.random());
			int i2 = 1 + (int) (6 * Math.random());
			int i3 = 1 + (int) (6 * Math.random());
			
			sum = i1 + i2 + i3;
			System.out.printf("%d: %d (%d, %d, %d)\n", i, sum, i1, i2, i3);
			i++;
			
			if (sum >= 18)
				break;
		} while (sum <= 15);
	}

}
