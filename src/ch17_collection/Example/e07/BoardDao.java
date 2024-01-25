package ch17_collection.Example.e07;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
	public List<Board> getBoardList() {
		List<Board> board = new ArrayList<Board>();
		
		for (int i = 1; i <= 3; i++)
		{
			Board bod = new Board("제목" + i, "내용" + i);
			board.add(bod);
		}
		
		return board;
	}
}
