package extra_crawling.sec01_human_edu;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Exercise {

	public static void main(String[] args) throws IOException {

		// 크롤링 : 타 웹 사이트의 데이터 가져오기
		
		// 접속할 url
		String url = "https://www.human.or.kr/";
		
		// Jsoup을 통해 링크의 문서를 내려받음
		Document doc = Jsoup.connect(url).get();
		
		// f_right 클래스의 하위 strong 태그를 선택
		Element strong = doc.selectFirst(".f_right > strong"); // 1개의 엘리먼트 선택
		
		// 선택된 요소의 text를 출력
		System.out.println(strong.text());
		
		Element address = doc.selectFirst(".f_left > address");
		System.out.println(address.html());
		
		String[] addressArray = address.html().split("<br>");
		List<String> addressList = new ArrayList<>();
		
		for (String addr: addressArray)
		{
			addressList.add(addr.strip());
		}
		addressList.forEach(x -> System.out.println(x));
		
	
		url = "https://www.human.or.kr/program?sca=%EC%88%98%EC%9B%90";
		// 링크에 한글이 있으면 특수한 문구로 인코딩되어 보임
		// %EC%88%98%EC%9B%90는 URLEncoder.encode("수원", "utf-8")으로 대체 가능
		
		url = "https://www.human.or.kr/program?sca=" + URLEncoder.encode("수원", "utf-8");
		doc = Jsoup.connect(url).get();
		
		
		System.out.println("=================================================================================");
		// 여러개의 엘리먼트
		// dp_li num-1 클래스가 달린 태그를 모두 찾음
		Elements lis = doc.select(".dp_li.num-1");
		System.out.println(lis.size());
		
		Element li = lis.get(0); // lis 중에 첫 번째
		String title = li.selectFirst(".txt_wrap > h2").text().strip(); // li 내부의 txt_wrap 클래스 하위의 h2를 찾아 텍스트 저장
		String desc = li.selectFirst(".txt_content").text().strip();
		System.out.println(title);
		System.out.println(desc);
		System.out.println("=================================================================================");
		
		// for로 만들기
		for (Element e: lis)
		{
			String title2 = e.selectFirst(".txt_wrap > h2").text().strip();
			String desc2 = e.selectFirst(".txt_content").text().strip();
			System.out.println(title2);
			System.out.println(desc2);
		}
		
		// 서울, 수원, 천안의 과정을 출력
		System.out.println("=================================================================================");
		
		for (String place: new String[] {"서울", "수원", "천안"})
		{
			url = "https://www.human.or.kr/program?sca=" + URLEncoder.encode(place, "utf-8");
			doc = Jsoup.connect(url).get();
			System.out.println("---------------------------"+ place +"---------------------------");
			Elements lis2 = doc.select(".dp_li.num-1");
			System.out.println("과정수: " + lis2.size());
			System.out.println("----------------------------------------------------------");
			
			for (Element e: lis2)
			{
				String title2 = e.selectFirst(".txt_wrap > h2").text().strip();
				//String desc2 = e.selectFirst(".txt_content").text().strip();
				System.out.println(title2);
				//System.out.println(desc2);
			}
			//System.out.println("----------------------------------------------------------");
		}
	}

}
