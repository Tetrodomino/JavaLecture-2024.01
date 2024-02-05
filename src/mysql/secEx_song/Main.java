package mysql.secEx_song;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		SongDao songDao = new SongDao();

		// sid로 데이터 찾기
		Song song = songDao.getSongById(101);
		System.out.println(song);
		
		// title로 데이터 찾기
		song = songDao.getSongBtTitle("A");
		System.out.println(song);
		
		System.out.println("────────────────────────────────────");
		
		// 전체 리스트 출력
		List<Song> list = songDao.getSongList();
		list.forEach(x -> System.out.println(x));
		
		System.out.println("────────────────────────────────────");
		
		// n번부터 k번까지 출력
		list = songDao.getSongListRange(105, 110);
		list.forEach(x -> System.out.println(x));
		
		System.out.println("────────────────────────────────────");

		// 새로운 데이터 넣기
		song = new Song("Twice", "cheer up baby cheer up baby");
		//songDao.insertSong(song);
		
		System.out.println("────────────────────────────────────");
		
		// 데이터 수정
		song = new Song(117, "Cheer up", "cheer up baby cheer up baby");
		//songDao.updateSong(song);
		
		System.out.println("────────────────────────────────────");
		
		// 데이터 삭제
		songDao.deleteSong(117);
		
		list = songDao.getSongList();
		list.forEach(x -> System.out.println(x));
	}

}
