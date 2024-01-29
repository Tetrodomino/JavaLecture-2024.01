package ch18_io;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class Ex03_OutputStream {

	public static void main(String[] args) {

		// 파일 만들기
		try {
			OutputStream os = new FileOutputStream("C:/Temp/output.txt");
			
			// 파일에 넣을 데이터 생성
			byte a = 0x41;
			char b = 'B';
			int c = 'C';
			
			// 데이터 추가
			os.write(a);
			os.write(b);
			os.write(c);
			
			// 배열도 추가 가능
			byte[] arr = {97, 98, 99, 100, 101};
			os.write(arr);
			
			os.write(arr, 1, 3); // arr의 1번째부터 3바이트 크기의 데이터를 추가 (영어는 1바이트이므로 1번째 ~ 3번째까지가 추가)
			
			os.flush(); // 파일이 없으면 해당 내용으로 만들기, 동명의 파일이 있으면 덮어쓰기
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
