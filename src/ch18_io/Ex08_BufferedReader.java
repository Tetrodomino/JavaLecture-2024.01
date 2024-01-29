package ch18_io;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex08_BufferedReader {

	public static void main(String[] args) throws Exception {

		// 줄 단위로 읽는 기능
		BufferedReader reader = new BufferedReader(new FileReader("C:/Temp/README.md"));
		
		int lineNo = 1;
		while (true)
		{
			String line = reader.readLine();
			if (line == null)
				break;
			
			System.out.println(lineNo + ": " + line);
			lineNo++;
		}
		
		reader.close();
	}

}
