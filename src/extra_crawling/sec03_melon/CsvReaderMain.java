package extra_crawling.sec03_melon;

import java.util.List;

import extra_crawling.csv.CsvUtil;
import extra_crawling.csv.CsvUtilImpl;

public class CsvReaderMain {

	public static void main(String[] args) {

		// Csv에 관한 클래스 호출
		CsvUtil csvUtil = new CsvUtilImpl();
		List<List<String>> csvList = csvUtil.readCsv("C:/Temp/melonchart.csv", "\t");
		
		for (List<String> line: csvList)
		{
			// line의 정보를 하나씩 읽음
			MelonChart me = new MelonChart(
					Integer.parseInt(line.get(0)),
					line.get(1),
					line.get(2),
					line.get(3),
					line.get(4));
			
			// ib를 그냥 출력
			System.out.println(me);
		}
	}

}
