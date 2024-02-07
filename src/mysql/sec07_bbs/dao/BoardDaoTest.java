package mysql.sec07_bbs.dao;

import java.util.List;

import mysql.sec07_bbs.entity.Board;

public class BoardDaoTest {

	public static void main(String[] args) {
		

		BoardDao bd = new BoardDao();
		
		//Board b = new Board("제목1", "내용내용내용", "james");
		List<Board> list = bd.getBoardList("content", "내", 1, 0);
		
//		bd.insertBoard();
		
		list.forEach(x -> System.out.println(x));
	}

}
