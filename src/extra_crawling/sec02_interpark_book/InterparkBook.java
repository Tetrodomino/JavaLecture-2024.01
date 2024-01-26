package extra_crawling.sec02_interpark_book;

public class InterparkBook {

	private int rank;
	private String title;
	private String author;
	private String company;
	private int price;
	
	public InterparkBook(int rank, String title, String author, String company, int price) {
		super();
		this.rank = rank;
		this.title = title;
		this.author = author;
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
		return String.format("%2d %s    %s  %s  %,d", rank, title, author, company, price);
	}
	
	
}
