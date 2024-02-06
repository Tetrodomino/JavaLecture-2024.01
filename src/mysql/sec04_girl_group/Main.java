package mysql.sec04_girl_group;

public class Main {

	public static void main(String[] args) {

		GirlGroupDao ggDao = new GirlGroupDao();
		
		GirlGroup gg = ggDao.getGirlGroupByGid(1001);
		System.out.println(gg);
		
		gg = ggDao.getGirlGroupByName("소녀");
		System.out.println(gg);		
		
		ggDao.close();
	}

}
