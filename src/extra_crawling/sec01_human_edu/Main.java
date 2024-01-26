package extra_crawling.sec01_human_edu;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 리스트를 통해 모아둔 데이터 효과적으로 보여주기
		List<Course> list = new ArrayList<Course>();
		
		for (String place: new String[] {"서울", "수원", "천안"})
		{
			String url = "https://www.human.or.kr/program?sca=" + URLEncoder.encode(place, "utf-8");
			Document doc = Jsoup.connect(url).get();
			System.out.println("-----------------------------"+ place +"-----------------------------");
			Elements lis2 = doc.select(".dp_li.num-1");
			System.out.println("과정수: " + lis2.size());
			
			for (Element e: lis2)
			{
				String title = e.selectFirst(".txt_wrap > h2").text().strip();
				String desc = e.selectFirst(".txt_content").text().strip();
				Course course = new Course(place, title, desc);
				list.add(course);
			}
			//System.out.println("----------------------------------------------------------");
		}
		System.out.println("--------------------------------------------------------------");
		for (Course c: list)
		{
			System.out.println(c);
		}
	}

}
