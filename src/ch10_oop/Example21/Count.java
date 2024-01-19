package ch10_oop.Example21;

import java.util.Scanner;

public class Count {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("───────────────────────────────────────────");
		System.out.println("글 입력▽");
		String text = scan.nextLine();
		
//		System.out.println("───────────────────────────────────────────");
//		System.out.print("찾을 단어 입력:");
//		String search = scan.nextLine();
		
		int count = text.length();			// 글자수
		int count_noblank = 0;				// 공백, 특수문자 제외 글자수
		int count_word = 0;					// 단어의 개수
		int count_word_noduplication = 0;	// 단어의 개수(중복 제외)
		
		String text2 = text.replaceAll("[,?. ]", "");
		count_noblank = text2.length();
		
		String[] text_array = text.split(" ");
		count_word = text_array.length;
		
		System.out.println("글자수: " + count);
		System.out.println("공백, 특수문자 제외 글자수: " + count_noblank);
		System.out.println("단어의 개수: " + count_word);
		
		String[] text_array2 = RemoveDuplication(text_array);
		
		for (int i = 0; i < text_array2.length; i++)
		{
			if (text_array2[i] != "no_count_string")
				count_word_noduplication++;
		}
		
		System.out.println("중복을 제외한 단어의 개수: " + count_word_noduplication);
		
		scan.close();
	}
	
	
	static String[] RemoveDuplication(String[] text_array) {
		
		for (int i = 0; i < text_array.length; i++)
		{
			if (text_array[i] == "no_count_string")
				continue;
			
			for (int j = i+1; j < text_array.length; j++)
			{
				if (text_array[j] == "no_count_string")
					continue;
				
				if (text_array[i].equals(text_array[j]))
					text_array[j] = "no_count_string";
			}
		}
		
		return text_array;
	}
}
