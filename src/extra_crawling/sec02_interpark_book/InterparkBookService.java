package extra_crawling.sec02_interpark_book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class InterparkBookService {

	public List<InterparkBook> getBestSeller() throws IOException {
		// 인터파크 사이트 url
		String url = "https://book.interpark.com/display/collectlist.do?_method=bestsellerHourNew&bookblockname=b_gnb&booklinkname=%BA%A3%BD%BA%C6%AE%C1%B8&bid1=w_bgnb&bid2=LiveRanking&bid3=main&bid4=001";
		
		Document doc = Jsoup.connect(url).get();
		
		// 베스트셀러의 각 항목을 클래스랑 태그를 통해 추적
		Elements lis = doc.select(".rankBestContentList > ol > li");
		
		// 정보 담는 리스트
		List<InterparkBook> list = new ArrayList<InterparkBook>();
		
		for (Element li: lis)
		{
			// 랭크 값 추출하기
			Elements spans = li.select(".rankNumber.digit2 > span");
			String rank_ = "";
			for (Element span: spans)
			{
				String s = span.attr("class").strip();
				
				rank_ += s.charAt(s.length() - 1);
			}
			int rank = Integer.parseInt(rank_);
			
			// 랭크 값 추출 이후 각 데이터를 클래스를 이용해서 추출
			String title = li.selectFirst(".itemName").text().strip();
			String author = li.selectFirst(".author").text().strip();
			String company = li.selectFirst(".company").text().strip();
			int price = Integer.parseInt((li.selectFirst(".price > em").text().strip()).replace(",", ""));
			
			// InterparkBook 클래스에 데이터를 집어넣고 생성
			InterparkBook ib = new InterparkBook(rank, title, author, company, price);
			
			// 리스트에 추가
			list.add(ib);
		}
		
		return list;
	}
}
