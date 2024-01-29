package ch18_io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Ex01_File {
	public static void main(String[] args) throws IOException {
		
		// 특정 경로의 파일 호출하기
		File file = new File("C:/Temp/README.md");
		
		// 디렉토리 사용
		File dir = new File("C:/Temp/test");
		
		// 디렉토리가 존재하지 않으면 생성
		if (!dir.exists())
			dir.mkdir(); // make directory
		
		// 파일이 없으면 파일 생성
		if (!file.exists())
			file.createNewFile();
		
		
		/*
		 * 해당 자바 파일은
		C:/Workspace/Java/lesson/src/ch18_io
		에 있지만
		
		경로를 지정하지 않고 실행하면 실제 실행 위치는
		C:/Workspace/Java/lesson/bin
		에서 실행됨
		
		*/
		
		
		
		
		// cmd 창에서 dir \ temp 한 결과
		File temp = new File("C:/Temp");
		
		File[] contents = temp.listFiles(); // 경로 내의 파일 목록을 리턴
		
		for(File content: contents)
		{
			System.out.println(content);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd a HH:mm");
		
		for (File f: contents)
		{
			System.out.printf("%-24s", sdf.format(f.lastModified()));
			if (f.isDirectory())
				System.out.printf("%-14s %-20s%n", "<DIR", f);
			System.out.println(f.getName());
		}
	}
}
