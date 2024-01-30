package ch18_io;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex99_grep {

	public static void main(String[] args) throws Exception {
		// 줄 단위로 읽는 기능
		BufferedReader reader = new BufferedReader(new FileReader("C:/Temp/sample.txt"));
		String search = "aaa";
		
		int lineNo = 1;
		while (true)
		{
			String line = reader.readLine();
			if (line == null)
				break;
			
			String searchline = line.replace(search, "");
			if (line.length() != searchline.length())
			{
				System.out.println(lineNo + ": " + line);
			}
			lineNo++;
		}
		
		reader.close();
	}

}
