package extra_crawling.sec02_interpark_book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import extra_crawling.csv.CsvUtil;
import extra_crawling.csv.CsvUtilImpl;

public class CsvMain {

	public static void main(String[] args) throws IOException {
		// 인터파크 사이트의 베스트셀러 페이지의 정보를 tsv 파일로 저장하기
		
		// 인터파크 사이트 베스트셀러 정보를 담아줄 클래스 생성
		InterparkBookService interparkbookservice = new InterparkBookService();
		CsvUtil csvUtil = new CsvUtilImpl();
		
		// 인터파크 베스트셀러 순위 정보를 리스트에 저장
		List<InterparkBook> list = interparkbookservice.getBestSeller();
		List<List<String>> csvList = new ArrayList<List<String>>(); // interpark.tsv에 데이터를 저장할 용도의 리스트  생성
		
		// 리스트의 각 항목의 정보를 String으로 전환하여 파일에 남길 용도로 만든 리스트에 저장
		for(InterparkBook ib: list)
		{
			List<String> line = new ArrayList<String>();
			line.add(ib.getRank() + "");
			line.add(ib.getTitle()); line.add(ib.getAuthor());
			line.add(ib.getCompany());
			line.add(ib.getPrice() + "");
			csvList.add(line);
		}
		csvUtil.writeCsv("C:/Temp/interpark.tsv", csvList, "\t");
	}

}
