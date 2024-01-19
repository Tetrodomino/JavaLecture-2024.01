package ch06_class.sec05_Melon;

public class Interpark {
	private int rank;
	private String title;
	private String author;
	private String translator;
	private String company;
	private int price;
	
	public Interpark() {}
	
	public Interpark(int rank, String title, String author, String translator, String company, int price) {
		this.rank = rank;
		this.title = title;
		this.author = author;
		this.translator = translator;
		this.company = company;
		this.price = price;
	}
	
	public Interpark(int rank, String title, String author, String company, int price) {
		this.rank = rank;
		this.title = title;
		this.author = author;
		this.translator = null;
		this.company = company;
		this.price = price;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Interpark [rank=" + rank + ", title=" + title + ", author=" + author + ", translator=" + translator
				+ ", company=" + company + ", price=" + String.format("%,d", price) + "]"; // 가격에 천 단위 구분 기호 넣기
	}
	
	
}
