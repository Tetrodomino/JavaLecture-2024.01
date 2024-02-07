package mysql.sec06_user;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

public class UserServiceMySQLImpl implements UserService{

	private UserDao userDao = new UserDao();
	
	@Override
	// 매개변수 user는 아직 데이터가 암호화되지 않음
	// 따라서 이 메소드에서 패스워드를 암호화시키고 DB에 입력
	public void registerUser(User user) { 
		String hashedPwd = BCrypt.hashpw(user.getPwd(), BCrypt.gensalt());
		user.setPwd(hashedPwd);
		userDao.insertUser(user);
	}

	@Override
	public User getUserByUid(String uid) {
		User user = userDao.getUserByUid(uid);
		return user;
	}

	@Override
	public List<User> getUserList(int page) {
		int offset = (page - 1) * COUNT_PER_PAGE;
		List<User> list = userDao.getUserList(COUNT_PER_PAGE, offset);
		
		return list;
	}

	@Override
	public void updateUser(User user) {
		
	}

	@Override
	public void deleteUser(String uid) {
		
	}

	@Override
	public int login(String uid, String pwd) {
		User user = userDao.getUserByUid(uid);
		
		if (user == null)
			return USER_NOT_EXIST;
		
		if (!BCrypt.checkpw(pwd, user.getPwd()))
			return WRONG_PASSWORD;
		
		return CORRECT_LOGIN;
	}

	@Override
	public void close() {
		
	}

	
}
