package ch18_io;

import java.io.FileOutputStream;
import java.io.PrintStream;
public class Ex09_PrintStream {

	public static void main(String[] args) throws Exception {

		// 두 번째 매개변수에 true가 있으면 파일 내용을 덮어쓰지 않고 아래에 추가함 (append mode)
		// 두 번째 매개변수가 없으면 덮어쓰기 모드 (overwrite mode)
		PrintStream ps = new PrintStream(new FileOutputStream("C:/Temp/print.txt", true));
		
		ps.print("마치 ");
		ps.println("System.out이 출력하는 것처럼");
		ps.println("데이터를 출력합니다.");
		ps.println("아래와 같이 포맷티드 출력도 가능합니다.");
		ps.printf("%-6s%,8d\n", "딸기", 12000);
		ps.printf("%-6s%,8d", "사과", 3000);
		
		ps.flush();
		ps.close();
	}

}
