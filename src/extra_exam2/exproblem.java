package extra_exam2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exproblem {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("찾을 파일: ");
		String filename = scan.nextLine();
		scan.close();
		
		countword(filename);
		HexaDump(filename);
	}
	
	static void countword(String filename)
	{
		Map<String, Integer> word = new HashMap<String, Integer>();
		int char_count = 0;
		int word_count = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			int lineNo = 1;
			
			while (true) {
				String line = br.readLine();
				
				if (line == null)
					break;
				
				line = line.replaceAll("'s", "");
				line = line.replaceAll("['.,?:!\"]", "");
				String[] text_array = line.split(" ");
				word_count += text_array.length;
				
				for (int i = 0; i < text_array.length; i++)
				{
					String word2 = text_array[i].toLowerCase();
					char_count += word2.length();
					
					if (word.containsKey(word2))
					{
						int value = word.get(word2);
						word.replace(word2, value + 1);
					}
					else
					{
						word.put(word2, 1);
					}
				}
			}
			System.out.println("글자수(공백, 특수문자 제외): " + char_count);
			System.out.println("단어의 수: " + word_count);
			System.out.println("중복 제외 단어의 수: " + word.size());
			//System.out.println(word);
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String ss = "asdfds";
		ss.formatted("%x");
		System.out.println("=====가장 많이 나온 단어=====");
		int repeat = 10;
		int max_count = 0;
		int rank = 0;
		int dummy_rank = 1;
		while (repeat > 0)
		{
			int max_count_dummy = 0;
			String max_key = "";
			
			for (String key: word.keySet())
			{
				if (word.get(key) > max_count_dummy)
				{	
					max_count_dummy = word.get(key);
					max_key = key;
				}	
			}
			
			if (dummy_rank > 1 && max_count > max_count_dummy)
			{
				rank += dummy_rank;
				dummy_rank = 1;
			}
			else if (max_count == max_count_dummy)
			{	
				dummy_rank++;
			}
			else
				rank++;
			
			if (repeat == 1 && max_count_dummy < max_count)
				break;
			
			System.out.println(rank + ": " + max_key + " - " + max_count_dummy);
			if (repeat == 1 && max_count_dummy == max_count)
			{
				word.remove(max_key);
				continue;
			}
			else if (max_count_dummy == max_count)
			{
				word.remove(max_key);
				repeat--;
			}
			else
			{
				word.remove(max_key);
				max_count = max_count_dummy;
				repeat--;
			}
		}
	}
	
	static void HexaDump(String filename)
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			int lineNo = 1;
			
			Writer writer = new FileWriter("C:/Temp/Hamlet2.txt");
			
			while (true) {
				String line = br.readLine();
				String fileline = String.format("%-3x", lineNo-1) + "0: ";
				
				if (line == null)
					break;
				
				for (int i = 0; i < line.length(); i++)
				{
					char c = line.charAt(i);
					fileline += String.format("%-2x", (int) c) + " ";
				}
				writer.write(fileline + "\n");
				writer.flush();
				lineNo++;

			}
			
			writer.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
