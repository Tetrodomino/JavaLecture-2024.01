package mysql.sec02_kcity;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		CityDao cityDao = new CityDao();
		
		// id로 데이터 출력
		City city = cityDao.getCityById(2340);
		System.out.println(city);
		
		// name으로 데이터 출력
		city = cityDao.getCityByName("수원");
		System.out.println(city);		
		
		// 모든 데이터 출력
		List<City> list = cityDao.getCityListAll();
		list.forEach(x -> System.out.println(x));
		
		System.out.println("──────────────────────────────");
		
		// 데이터 추가
		city = new City("화성", "KOR", "Kyonggi", 900000);
		//cityDao.insertCity(city);
		
		// 데이터 수정
		city = cityDao.getCityById(2396);
		city.setName("의왕"); city.setPopulation(500000);
		//cityDao.updateCity(city);
		
		// 데이터 삭제 (id)
		cityDao.deleteCity(2401);
		
		// 특정 요소값의 데이터 출력
		list = cityDao.getCityListByDistrict("Kyonggi");
		list.forEach(x -> System.out.println(x));
		
		
	}

}
