package extra_crawling.sec03_melon;

public class MelonChart {

	private int rank;
	private String title;
	private String artist;
	private String album;
	private String src;
	
	public MelonChart() {}

	public MelonChart(int rank, String title, String artist, String album, String src) {
		this.rank = rank;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.src = src;
	}

	@Override
	public String toString() {
		return "MelonChart [rank=" + rank + ", title=" + title + ", artist=" + artist + ", album=" + album + ", src="
				+ src + "]";
	}
	
	
}
