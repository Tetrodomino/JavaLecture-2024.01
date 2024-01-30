package ch18_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Q21_Grep {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("찾을 문자열: ");
		String search = scan.nextLine();
		
		System.out.print("찾을 파일: ");
		String filename = scan.nextLine();
		scan.close();
		
		grep(search, filename);
	}
	
	static void grep(String word, String filename)
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			int lineNo = 1;
			
			while (true) {
				String line = br.readLine();
				
				if (line == null)
					break;
				
				String newLine = line.toLowerCase(); // 대문자를 소문자로 일괄 변환
				if (newLine.contains(word.toLowerCase()))
					System.out.printf("%4d:\t%s%n", lineNo, line);
				lineNo++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
