package extra_api;

public class KakaoLocalMain {

	public static void main(String[] args) throws Exception {

		KakaoLocalApi api = new KakaoLocalApi();
		System.out.println(api.getGeocode("경기 수원시 영통구 이의동 0"));
	}

}
