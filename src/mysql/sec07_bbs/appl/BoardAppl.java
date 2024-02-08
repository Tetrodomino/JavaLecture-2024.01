package mysql.sec07_bbs.appl;

import java.util.List;

import mysql.sec07_bbs.entity.Board;
import mysql.sec07_bbs.service.BoardService;
import mysql.sec07_bbs.service.BoardServiceMySQLImpl;

public class BoardAppl {

	public static void main(String[] args) {

		BoardService bSvc = new BoardServiceMySQLImpl();
		
		List<Board> list = bSvc.getBoardList(1, null, null);
		
		list.forEach(x -> System.out.println(x.listForm()));
		System.out.println("──────────────────────────────────────────");
		
		Board board = bSvc.getBoard(15);
		System.out.println(board);
		if (board.getReplyList() != null)
			board.getReplyList().forEach(x -> System.out.println(x));
		
		bSvc.close();
	}

}
