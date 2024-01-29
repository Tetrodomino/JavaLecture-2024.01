package ch18_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex04_Copy {

	public static void main(String[] args) throws Exception {

		// 복사할 파일과 복사한 파일의 이름
		String srcFile = "C:/Temp/cat.jpg", dstFile = "C:/Temp/고양이.jpg";
		
		InputStream is = new FileInputStream(srcFile);
		OutputStream os = new FileOutputStream(dstFile);
		
		byte[] buffer = new byte[1024];
		while (true)
		{
			int num = is.read(buffer); // 1024 바이트 크기만큼 파일의 데이터를 읽음
			if (num == -1) // 파일 읽기가 끝나면 탈출
				break;
			
			os.write(buffer, 0, num); // 데이터가 들어간 buffer의 크기만큼 os에 작성
		}
		
		os.flush(); os.close(); is.close();
		System.out.println("Copy is done");
	}

}
