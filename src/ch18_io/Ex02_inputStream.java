package ch18_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_inputStream {

	public static void main(String[] args) throws IOException {

		InputStream is = new FileInputStream("C:/Temp/README.md");
		
		// 파일 읽는 방법 1
		// 한글은 깨짐
		while (true)
		{
			int data = is.read(); 		// 1바이트를 읽어서 정수형으로 변환
			
			if (data == -1) 			// 마지막 데이터는 항상 -1이 됨
			{
				break;
			}
			
			System.out.print((char)data);
		}
		
		is.close();
		System.out.println();
		
		
		// 이렇게도 선언 가능
		is = new FileInputStream(new File("C:/Temp/README.md"));
		
		
		// 파일 읽는 방법 2
		// 한글이 깨지지 않음
		byte[] arr = new byte[512];
		while (true)
		{
			int num = is.read(arr);
			System.out.println("읽은 바이트 수: " + num);
			if (num == -1)
				break;
		}
		System.out.println(new String(arr));
		is.close();
	}

}
