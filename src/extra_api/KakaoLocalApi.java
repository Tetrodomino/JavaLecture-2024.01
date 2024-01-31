package extra_api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * 도로명주소로부터 위도(latitude), 경도(longitude) 정보를 구해주는 메소드
 */
public class KakaoLocalApi {
	public Map<String, Double> getGeocode(String addr) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("C:/Temp/kakaoApiKey.txt"));
		String kakaoKey = br.readLine(); br.close();
		
		String query = URLEncoder.encode(addr, "utf-8");
		String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json"
				+ "?query=" + query;
		
		URL url = new URL(apiUrl);
		
		// 헤더 설정
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("Authorization", "KakaoAK " + kakaoKey);
		
		// 응답 결과 확인
		int responseCode = conn.getResponseCode();
		//System.out.println(responseCode); // 나오는 값에 따라 서버 응답의 결과가 달라짐
		
		// 응답받은 파일을 읽음
		br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		StringBuffer sb = new StringBuffer();
		String line = null;
		
		// 파일을 한 줄씩 읽어서 sb에 추가
		while ((line = br.readLine()) != null)
			sb.append(line);
		br.close();
		//System.out.println(sb.toString()); // sb 출력
		
		// 원하는 데이터만 골라가는 과정
    	JSONParser parser = new JSONParser();
    	
    	JSONObject object = (JSONObject) parser.parse(sb.toString()); // sb.toString 전체를 JsonObject로 만들기
    	//System.out.println(object.keySet()); object에 있는 key 값 출력
    	
    	
		JSONArray documents = (JSONArray) object.get("documents"); // 키 중 documents에 해당하는 배열 [] 가져오기
																   // docuemnts의 값은 []으로 감싸져 있어서 배열로 가져와야 함
		//System.out.println(documents.size()); // documents의 크기
		
		JSONObject item = (JSONObject) documents.get(0); // documents의 1번째 값만 추리기
		//System.out.println(item.keySet()); // item의 key 값
		
		// x와 y 키가 나왔으므로 마지막으로 x와 y를 찾기
		String lon_ = (String) item.get("x");
		String lat_ = (String) item.get("y");
//		System.out.println("x: " + lon_);
//		System.out.println("y: " + lat_);
		
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("lon", Double.parseDouble(lon_));
		map.put("lat", Double.parseDouble(lat_));
		
		return map;
	}
	
}
