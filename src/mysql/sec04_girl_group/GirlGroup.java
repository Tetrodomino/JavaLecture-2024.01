package mysql.sec04_girl_group;

import java.time.LocalDate;

public class GirlGroup {

	private int gid;
	private String name;
	private LocalDate debut;
	private int hit_song_id;		// insert, update 할 때 사용하는 기존 필드
	private String  hit_song_title;	// select 할 때 사용하기 위해 원래 데이터에는 없던 필드
	
	public GirlGroup() {}
	
	// insert 할 때 사용되는 생성자
	public GirlGroup(String name, LocalDate debut, int hit_song_id) {
		this.name = name;
		this.debut = debut;
		this.hit_song_id = hit_song_id;
	}	
	
	// update 할 때 사용되는 생성자
	public GirlGroup(int gid, String name, LocalDate debut, int hit_song_id) {
		this.gid = gid;
		this.name = name;
		this.debut = debut;
		this.hit_song_id = hit_song_id;
	}

	public GirlGroup(int gid, String name, LocalDate debut, int hit_song_id, String hit_song_title) {
		this.gid = gid;
		this.name = name;
		this.debut = debut;
		this.hit_song_id = hit_song_id;
		this.hit_song_title = hit_song_title;
	}

	@Override
	public String toString() {
		return "GirlGroup [gid=" + gid + ", name=" + name + ", debut=" + debut + ", hit_song_title=" + hit_song_title + "]";
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDebut() {
		return debut;
	}

	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	public int getHit_song_id() {
		return hit_song_id;
	}

	public void setHit_song_id(int hit_song_id) {
		this.hit_song_id = hit_song_id;
	}

	public String getHit_song_title() {
		return hit_song_title;
	}

	public void setHit_song_title(String hit_song_title) {
		this.hit_song_title = hit_song_title;
	}
	
	
}
