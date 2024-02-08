package mysql.sec07_bbs.dao;

import java.util.List;

import mysql.sec07_bbs.entity.Board;

public class BoardDaoTest {

	public static void main(String[] args) {
		BoardDao bd = new BoardDao();
		String sessionUid = "james";	// 제임스가 로그인한 것으로 가정
		
		//Board b = new Board("제목1", "내용내용내용", "james");
		List<Board> list = bd.getBoardList("b.uid", "james", 10, 0);
		
//		bd.insertBoard();
		
		Board b = bd.getBoard(12);
		if (!b.getUid().equals(sessionUid)) // 제임스가 작성한 글이 아니면 조회수올리기
			bd.increaseCount("view", 12);
		
		b = bd.getBoard(12);
		System.out.println(b);
		
//		Board b = new Board("제목12", "본문12", "james");
//		bd.insertBoard(b);
//		b = new Board("제목13", "본문13", "james");
//		bd.insertBoard(b);
//		b = new Board("제목14", "본문14", "maria");
//		bd.insertBoard(b);
//		b = new Board("제목15", "본문15", "brian");
//		bd.insertBoard(b);
//		b = new Board("제목16", "본문16", "sarah");
//		bd.insertBoard(b);
		
//		list = bd.getBoardList("title", "%", 10, 0);
//		list.forEach(x -> System.out.println(x.listForm()));
//		System.out.println("=======================================================");
//
//		list = bd.getBoardList("b.uid", "james", 10, 0);
//		list.forEach(x -> System.out.println(x.listForm()));
//		System.out.println("=======================================================");
//
//		list = bd.getBoardList("uname", "마리아", 10, 0);
//		list.forEach(x -> System.out.println(x.listForm()));
//		System.out.println("=======================================================");
		
		bd.close();
	}

}
