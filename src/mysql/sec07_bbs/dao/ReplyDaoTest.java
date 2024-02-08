package mysql.sec07_bbs.dao;

import java.util.List;

import mysql.sec07_bbs.entity.Reply;

public class ReplyDaoTest {

	public static void main(String[] args) {
		
		String sessionUid = "sarah"; // 현재 로그인한 id
		int bid = 12;
		
		BoardDao bd = new BoardDao();

		ReplyDao rd = new ReplyDao();
		Reply r = new Reply();
		r.setComment("댓글3");
		r.setUid(sessionUid);
		r.setBid(bid);
		
		rd.insertReply(r);
		bd.increaseCount("reply", bid);
		
		List<Reply> list = rd.getReplyList(bid);
		list.forEach(x -> System.out.println(x));
		
		bd.close(); rd.close();
	}

}
