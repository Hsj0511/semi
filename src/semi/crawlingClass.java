package semi;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class crawlingClass {

	public static void main(String[] args) throws IOException {
		Document doc1 = Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ot=1").get();
		
		
		System.out.println("예매순");
		Elements book_ranks = doc1.select("div.box-image strong.rank");
		Elements book_titles = doc1.select("div.box-contents strong.title");
		Elements book_percents = doc1.select("div.box-contents > div.score > strong.percent > span");
		Elements book_eggs = doc1.select("div.box-contents > div.score > div.egg-gage.small > span.percent");
		for (int i = 0; i < 10; i++) {
			Element book_rank = book_ranks.get(i);
			Element book_title = book_titles.get(i);
			Element book_percent = book_percents.get(i);
			Element book_egg = book_eggs.get(i);
			System.out.println(book_rank.text() + ":" +book_title.text() + ":" + book_percent.text() + ":"+book_egg.text());
			
		}
			
			
			
			Document doc2 = Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ot=2").get();
			System.out.println("평점순");
			Elements rating_ranks = doc1.select("div.box-image strong.rank");
			Elements rating_titles = doc2.select("div.box-contents strong.title");
			Elements rating_percents = doc2.select("div.box-contents > div.score > strong.percent > span");
			Elements rating_eggs = doc2.select("div.box-contents > div.score > div.egg-gage.small > span.percent");
			
			for (int j = 0; j < 10; j++) {
				Element rating_rank = rating_ranks.get(j);
				Element rating_title = rating_titles.get(j);
				Element rating_percent = rating_percents.get(j);
				Element rating_egg = rating_eggs.get(j);

				System.out.println(rating_rank.text() + ":" +rating_title.text() + ":" + rating_percent.text() +":" +rating_egg.text());
			
	}

	
	}
	

	
}