package extra_crawling.sec03_melon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	/*
	 * 크롤링 7단계
	 *
	 * 1. 사이트에 접속하고 HTML 데이터를 가져와 피싱
	 *
	 * 2. 원하는 데이터 찾기 (<li>태그, <tr>태그 등)
	 * 
	 * 3. 하나를 선택해서 원하는 정보 추출
	 * 
	 * 4. 반복문을 사용하여 페이지 내에 있는 데이터 가져오기
	 * 
	 * 5. 오류가 발생하면 오류를 해결하고 2, 3, 4 과정을 반복
	 * 
	 * 6. 모든 페이지에 대해 반복
	 * 
	 * 7. CSV(Comma Separated Values) 파일로 만들기
	 */

	public static void main(String[] args) throws IOException {

		// 1. 사이트에 접속하고 HTML 데이터를 가져와 피싱
		String url = "https://www.melon.com/chart/index.htm";
		Document doc = Jsoup.connect(url).get();
		
		// 2. 원하는 데이터 찾기 (<li>태그, <tr>태그 등)
		Elements trs = doc.select(".service_list_song.type02.d_song_list > table > tbody > tr");
		
		// 4. 반복문을 사용하여 페이지 내에 있는 데이터 가져오기 (3번은 Exercise에서 함)
		List<MelonChart> list = new ArrayList<>();
		for (Element tr: trs)
		{
			String rank_ = tr.selectFirst(".rank").text().strip();
			int rank = Integer.parseInt(rank_);
			String title = tr.selectFirst(".ellipsis.rank01 > span > a").text().strip();
			String artist = tr.selectFirst(".ellipsis.rank02 > a").text().strip();
			String album = tr.selectFirst(".ellipsis.rank03 > a").text().strip();
			String src = tr.selectFirst("td:nth-child(4) > div > a > img").attr("src");
			
			MelonChart mc = new MelonChart(rank, title, artist, album, src);
			list.add(mc);
		}
		
		// 5. 에러 확인
//		for (int i = 0; i < trs.size(); i++)
//		{
//			try {
//				Element tr = trs.get(i);
//			} catch (Exception e) {
//				System.out.println(i); // 에러가 발생했을 경우 몇 번째 데이터에서 에러가 발생했는지 확인
//			}
//		}
		
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}

}
