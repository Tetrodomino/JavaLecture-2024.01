package Challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Countword {

	public static void main(String[] args) throws Exception {

		// 파일 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("찾을 파일> ");
		String filename = scan.nextLine();
		scan.close();
		
		// 파일 이름으로 파일 버퍼리더 받아오기
		BufferedReader br = new BufferedReader(new FileReader(filename));

		Set<String> wordSet = new HashSet<String>();		// 고유 단어
		List<String> wordList = new ArrayList<String>();	// 단어(중복가능)
		String line = null;
		int count = 0;				// 문자 갯수
		
		// 줄 하나씩 받아서 빈 줄이 나오기 전까지 반복
		while((line = br.readLine()) != null) {
			// 글자의 수 만큼 글자수 더하기
			count += line.length();
			
			// 숫자, 영어, 한글을 제외한 모든 문자 제거
			String cleanText = line.replaceAll("[^0-9A-Za-zㄱ-ㅎㅏ-ㅣ가-힣]", " ");
			
			String[] cleanWords = cleanText.split("\\s+");	// 임의의 연속된 공백으로 단어 분리
			
			// 만들어진 문자열 배열의 요소를 하나씩 검사하여 Set이랑 List에 넣기
			for (String word: cleanWords) {
				if (word.equals(""))
					continue;
				wordSet.add(word.toLowerCase()); // Set은 같은 값을 넣으면 중복처리하므로 소문자로 변환해서 넣기
				wordList.add(word);
			}
		}
		br.close();
		System.out.println(wordSet.size() + ", " + wordList.size() + ", " + count);
		System.out.println(wordSet);
	}

}
