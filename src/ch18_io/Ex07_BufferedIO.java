package ch18_io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex07_BufferedIO {

	public static void main(String[] args) throws Exception {

		// buffer를 썼을 때와 안 섰을 때 비교
		
		// 1. 버퍼를 안 썼을 때
		InputStream is = new FileInputStream("C:/Temp/eiffel.jpg");
		OutputStream os = new FileOutputStream("C:/Temp/에펠탑.jpg");
		
		long noBufferTime = copy(is, os);
		System.out.println("버퍼를 안 썼을 때: " + noBufferTime);
		
		// 2. 버퍼를 썼을 때
		is = new BufferedInputStream(new FileInputStream("C:/Temp/eiffel.jpg"));
		os = new BufferedOutputStream(new FileOutputStream("C:/Temp/에펠탑.jpg"));
		
		long bufferTime = copy(is, os);
		System.out.println("버퍼 사용: " + bufferTime); // 훨씬 적은 시간이 걸림
		is.close(); os.close();
	}

	static long copy(InputStream is, OutputStream os) throws Exception
	{
		long startTime = System.nanoTime();
		
		// 1바이트씩 읽고 쓰기
		while (true)
		{
			int data = is.read();
			if (data == -1)
				break;
			os.write(data);
		}
		os.flush();
		
		long endTime = System.nanoTime();
		
		return endTime - startTime;
	}
}
