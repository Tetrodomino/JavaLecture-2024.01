package ch18_io;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class Ex05_Reader {

	public static void main(String[] args) throws Exception {

		// 파일을 문자로 읽어주는 FileReader
		Reader reader = new FileReader("C:/Temp/README.md");
		
		// 1문자씩 읽기
		while (true) {
			int data = reader.read();
			if (data == -1)
				break;
			
			System.out.print((char) data); // inputStream과는 달리 한글이 깨지지 않음
		}
		
		reader.close();
		System.out.println();
		
		reader = new FileReader(new File("C:/Temp/README.md"));
		
		// 배열로 문자 한꺼번에 여러개 읽기
		char[] buffer = new char[100];
		
		while (true)
		{
			int num = reader.read(buffer); // buffer의 크기만큼 읽기
			
			System.out.println("읽은 문자수: " + num);
			if (num == -1)
				break;
			
			System.out.println(new String(buffer));
			
		}
		reader.close();
	}

}
