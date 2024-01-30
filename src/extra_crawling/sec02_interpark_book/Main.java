package extra_crawling.sec02_interpark_book;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		InterparkBookService interparkbookservice = new InterparkBookService();
		List<InterparkBook> list = interparkbookservice.getBestSeller();
		
	}

}
