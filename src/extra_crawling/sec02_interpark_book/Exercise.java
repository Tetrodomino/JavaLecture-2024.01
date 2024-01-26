package extra_crawling.sec02_interpark_book;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Exercise {

	public static void main(String[] args) throws IOException {

		String url = "https://book.interpark.com/display/collectlist.do?_method=bestsellerHourNew&bookblockname=b_gnb&booklinkname=%BA%A3%BD%BA%C6%AE%C1%B8&bid1=w_bgnb&bid2=LiveRanking&bid3=main&bid4=001";
	
		Document doc = Jsoup.connect(url).get();
		
		Elements lis = doc.select(".rankBestContentList > ol > li");
		System.out.println(lis.size());
		
		Element li = lis.get(9);
		String title = li.selectFirst(".itemName").text().strip();
		String author = li.selectFirst(".author").text().strip();
		String company = li.selectFirst(".company").text().strip();
		int price = Integer.parseInt((li.selectFirst(".price > em").text().strip()).replace(",", ""));
		System.out.println(title);
		System.out.println(author);
		System.out.println(company);
		System.out.println(price);
	}

}
