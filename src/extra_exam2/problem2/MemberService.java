package extra_exam2.problem2;

import java.util.ArrayList;
import java.util.List;

public class MemberService {

	public List<Member> getMemberList() {
		
		Member mem1 = new Member(1, "james", 1990, "000-1234-5678");
		Member mem2 = new Member(2, "maria", 1991, "000-3141-5928");		
		
		List<Member> list = new ArrayList<Member>();
		list.add(mem1);
		list.add(mem2);
		
		return list;
	}
}
