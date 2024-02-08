package mysql.sec07_bbs.appl;

import java.util.List;

import mysql.sec07_bbs.entity.User;
import mysql.sec07_bbs.service.UserService;
import mysql.sec07_bbs.service.UserServiceMySQLImpl;

public class UserTest {

	public static void main(String[] args) {

		UserService userSvc = new UserServiceMySQLImpl();
		
//		User user = new User("admin", "1234", "관리자", "admin@naver.com");
//		userSvc.registerUser(user);
//		user = new User("james", "12345", "제임스", "james@naver.com");
//		userSvc.registerUser(user);
//		user = new User("maria", "12346", "마리아", "maria@naver.com");
//		userSvc.registerUser(user);
//		user = new User("brian", "12347", "브라이언", "brian@naver.com");
//		userSvc.registerUser(user);
//		user = new User("sarah", "12348", "사라", "sarah@naver.com");
//		userSvc.registerUser(user);
		
		//System.out.println(userSvc.login("admin", "12345"));
		
		List<User> list = userSvc.getUserList(1);
		list.forEach(x -> System.out.println(x));
		
		userSvc.close();
	}

}
