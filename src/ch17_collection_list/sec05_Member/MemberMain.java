package ch17_collection_list.sec05_Member;

import java.util.ArrayList;
import java.util.List;

public class MemberMain {
	private static List<Member> list = new ArrayList<Member>();
	
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) 
		{
			int age = 20 + (int) (Math.random() * 20);
			list.add(new Member(age, "이름" + i, Math.random() > 0.5 ? "남" : "여"));
		}
		//for (Member m: list)
			//System.out.println(m);
		System.out.println("=====================================");
		
		// 나이가 30세 초과인 멤버 리스트
		List<Member> mList = getMemberListAbove30();
		
		for (Member m: mList)
			System.out.println(m);
		
		System.out.println("=====================================");
		
		// 남자 리스트
		mList = getMemberListByGender("남");
		for (Member m: mList)
			System.out.println(m);

		System.out.println("=====================================");
		
		// 새로운 멤버 추가
		Member member = new Member(39, "제임스", "남");
		insertMember(member);
		
		for (Member m: list)
			System.out.println(m);
		
		System.out.println("=====================================");
		
		// 특정 이름의 멤버 삭제
		deleteMember("제임스");
		for (Member m: list)
			System.out.println(m);
		
		System.out.println("=====================================");
		
		// 여자 멤버의 나이를 -1 해서 출력
		// 여자 리스트
		mList = getMemberListByGender("여");
		for (Member m: mList)
		{	
			updateMember(m);
			System.out.println(m);
		}
	}

	
	static List<Member> getMemberListAbove30()
	{
		List<Member> mList = new ArrayList<>();
		for (Member m: list)
		{
			if (m.getAge() > 30)
				mList.add(m);
		}
		
		return mList;
	}
	
	static List<Member> getMemberListByGender(String gender) {
		List<Member> mList = new ArrayList<>();
		for (Member m: list)
		{
			if (m.getGender().equals(gender))
				mList.add(m);
		}
		
		return mList;
	}
	
	static void insertMember(Member member)
	{
		list.add(member);
	}
	
	static void deleteMember(String name) {
		Member member = null;
		
		for (Member m: list)
		{
			if (m.getName().equals(name))
			{
				member = m;		
				break;
			}
		}
		
		list.remove(member);	// for 안에서 remove를 하면 재귀참조로 인해 오류가 발생하므로 for 밖에서 해야 됨
	}
	
	static void updateMember(Member member)
	{
		int index = list.indexOf(member);
		if (index >= 0) {
			member.setAge(member.getAge() - 1);
			list.set(index, member);
		}
	}
}
