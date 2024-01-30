package extra_crawling.sec03_melon;

import java.util.ArrayList;
import java.util.List;

import extra_crawling.csv.CsvUtil;
import extra_crawling.csv.CsvUtilImpl;

public class CsvMain {

	public static void main(String[] args) throws Exception {
		// 멜론의 차트 정보를 csv 파일로 저장하기
		
		// 멜론 차트 정보를 퍼올 클래스 생성
		MelonChartService melonchartservice = new MelonChartService();
	
		CsvUtil csvUtil = new CsvUtilImpl();
		
		// 인터파크 베스트셀러 순위 정보를 리스트에 저장
		List<MelonChart> list = melonchartservice.getMelonChart();
		List<List<String>> csvList = new ArrayList<List<String>>(); // melon.csv에 데이터를 저장할 용도의 리스트  생성
		
		// 리스트의 각 항목의 정보를 String으로 전환하여 파일에 남길 용도로 만든 리스트에 저장
		for(MelonChart me: list)
		{
			List<String> line = new ArrayList<String>();
			line.add(me.getRank() + "");
			line.add(me.getTitle());
			line.add(me.getArtist());
			line.add(me.getAlbum());
			line.add(me.getSrc());
			csvList.add(line);
		}
		csvUtil.writeCsv("C:/Temp/melonchart.txt", csvList, "\t");
	}

}
