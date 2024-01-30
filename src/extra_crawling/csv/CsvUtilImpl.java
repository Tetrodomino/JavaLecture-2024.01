package extra_crawling.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvUtilImpl implements CsvUtil {

	@Override
	public List<List<String>> readCsv(String filename) {
		return readCsv(filename, ",", 0);
	}

	@Override
	public List<List<String>> readCsv(String filename, String separator) {
		return readCsv(filename, separator, 0);
	}

	@Override
	public List<List<String>> readCsv(String filename, int skipLine) {
		return readCsv(filename, ",", skipLine);
	}

	@Override
	public List<List<String>> readCsv(String filename, String separator, int skipLine) {
		
		// 데이터를 담을 List 생성
		List<List<String>> csvList = new ArrayList<List<String>>();
		
		BufferedReader br = null;
		int lineNo = 0;
		
		try {
			// filename을 이용해 버퍼리더 생성
			br = new BufferedReader(new FileReader(filename));
			
			while (true)
			{
				String line = br.readLine(); // 데이터를 한 줄씩 읽기
				
				if (line == null) // 더 이상 읽을 라인이 없으면 브레이크
					break;
				
				if (skipLine > lineNo++) // 스킵할 줄의 개수보다 현재 줄의 번호가 작으면 컨티뉴
					continue;
				
				// 한 줄의 내용을 separator에 따라 분할하여 배열에 저장
				String[] lineArray = line.split(separator);
				
				// 배열을 리스트 형태로 변환하여 데이터를 담는 리스트 csvList에 저장
				csvList.add(Arrays.asList(lineArray));

				// 배열을 리스트 형태로 변환하는 건 아래 방식과 똑같음
//				List<String> lineList = new ArrayList<String>();
//				for (String word: lineArray)
//					lineList.add(word);
//				csvList.add(lineList);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return csvList;
	}

	@Override
	public void writeCsv(String filename, List<List<String>> dataList) {
		writeCsv(filename, dataList, ",");
	}

	@Override
	public void writeCsv(String filename, List<List<String>> dataList, String separator) {
		// try 전에 버퍼라이터 생성
		BufferedWriter bw = null;
		
		try {
			// 파일네임을 통해 버퍼 만들기
			bw = new BufferedWriter(new FileWriter(filename));
			
			// 정보가 담겨진 리스트의 항목을 하나하나 bw에 저장
			for (List<String> data: dataList)
			{
				String line = "";
				for (int i = 0; i < data.size(); i++)
				{
					line += data.get(i);
					if (i < data.size() - 1) // 각 항목의 사이마다 구분자(separator)를 삽입
						line += separator;
				}
				bw.write(line + "\n"); // 하나의 줄이 끝나면 줄바꿈 문자 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.flush(); // bw에 저장된 내용을 파일에 반영
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
