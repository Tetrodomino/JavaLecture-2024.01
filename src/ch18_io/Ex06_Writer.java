package ch18_io;

import java.io.FileWriter;
import java.io.Writer;

public class Ex06_Writer {

	public static void main(String[] args) throws Exception {
		
		// FileWriter를 이용해서 파일 작성

		Writer writer = new FileWriter("C:/Temp/output.txt");
		
		// 1문자씩 작성
		char a = 'A', b = 'B';
		
		writer.write(a); writer.write(b);
		
		// char 배열로 작성
		char[] arr = {'C', 'D', 'E'};
		
		writer.write(arr);
		
		// 문자열로 작성
		writer.write("FG\n");
		writer.write("한글도 써진다.\n");
		
		writer.flush();
		writer.close();
	}

}
