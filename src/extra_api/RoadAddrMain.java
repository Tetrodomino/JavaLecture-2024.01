package extra_api;

public class RoadAddrMain {

	public static void main(String[] args) throws Exception {

		RoadAddApi api = new RoadAddApi();
		System.out.println(api.getRoadAddr("경기도청"));
	}

}
