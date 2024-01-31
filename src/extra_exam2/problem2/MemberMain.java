package extra_exam2.problem2;

import java.util.List;
import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		List<Member> member = new MemberService().getMemberList();
		
		
		for (int i = 0; i < member.size(); i++)
		{
			Member m = member.get(i);
			
			System.out.println(m.getName() + "의 기존 전화번호: " + m.getTel());
			System.out.print("새 전화번호 입력(- 포함): ");
			String newTel = scan.nextLine();
			
			m.setTel(newTel);
		}
		scan.close();
		
		for (int i = 0; i < member.size(); i++)
		{
			System.out.println(member.get(i));
		}
	}
}
