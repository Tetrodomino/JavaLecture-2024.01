package mysql.sec06_user;

import org.mindrot.jbcrypt.BCrypt;

public class BcryptExample {

	public static void main(String[] args) {

		/*
		 * 암호화 
		 * 평문(plain text)에서 비문(cipher text)으로 바꾸기
		 * 
		 * 암호화에는 복원 가능 알고리즘(평문-비문 전환 가능)과
		 * 비복원 알고리즘 (평문에서 비문으로만 가능)이 존재
		 * 
		 * 여기서는 암호화로 BCrypt jar를 사용
		 */
		
		String pwd = "1234qwerty";
		
		// 패스워드를 암호화하는 메소드
		String hashedPwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
		
		System.out.println(hashedPwd.length());
		System.out.println(hashedPwd);
		
		// 패스워드가 동일한지 확인하는 메소드
		boolean result = BCrypt.checkpw(pwd, hashedPwd);
		System.out.println(result); // true
		
		// 실제 프로그램상에서는 패스워드를 사용자가 입력하면
		// DB에 저장되어 있는 hashedPwd와 비교하는 식으로 작동
	}

}
