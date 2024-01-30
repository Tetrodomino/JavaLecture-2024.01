package extra_api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RoadAddApi {

	public String getRoadAddr(String keyword) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("C:/Temp/roadApiKey.txt"));
		String confmKey = br.readLine(); br.close();
		int currentPage = 1;
		int countPerPage = 5;
		String resultType = "json";
		keyword = URLEncoder.encode(keyword, "utf-8"); // 한글을 utf-8로 변환하기
		
		// API주소 만들기
		String apiUrl = "https://www.juso.go.kr/addrlink/addrLinkApi.do"
				+ "?confmKey=" + confmKey
				+ "&currentPage=" + currentPage
				+ "&countPerPage=" + countPerPage
				+ "&resultType=" + resultType
				+ "&keyword=" + keyword;
		
		URL url = new URL(apiUrl);
		br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
    	StringBuffer sb = new StringBuffer();
    	String tempStr = null;
    	
    	while(true){
    		tempStr = br.readLine();
    		if(tempStr == null) break;
    		sb.append(tempStr);								// 응답결과 JSON 저장
    	}
    	br.close();
    	
    	// JSON 데이터에서 원하는 값 추출
    	// 전체 데이터에서부터 시작하여 순서대로 안쪽의 값을 찾아나가는 방식으로 진행
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(sb.toString()); // sb.toString 전체를 JsonObject로 만들기
    	JSONObject results = (JSONObject) object.get("results"); //"results": {} 에 해당하는 항목 가져오기
    	JSONArray juso = (JSONArray) results.get("juso");
    	JSONObject jusoItem = (JSONObject) juso.get(0);
    	String roadAddr = (String) jusoItem.get("roadAddr");
		
		return roadAddr;
		
	}
}
