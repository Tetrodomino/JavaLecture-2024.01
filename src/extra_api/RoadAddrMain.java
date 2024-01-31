package extra_api;

public class RoadAddrMain {

	public static void main(String[] args) throws Exception {

		RoadAddApi api = new RoadAddApi();
		System.out.println(api.getRoadAddr("경기 수원시 영통구 이의동 0"));
	}

}
