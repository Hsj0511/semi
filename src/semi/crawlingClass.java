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
		Elements ranks = doc1.select("div.box-image strong.rank");
		Elements titles = doc1.select("div.box-contents strong.title");
		Elements percents = doc1.select("div.box-contents > div.score > strong.percent > span");
		Elements eggs = doc1.select("div.box-contents > div.score > div.egg-gage.small > span.percent");
		for (int i = 0; i < 10; i++) {
			Element rank =ranks.get(i);
			Element title = titles.get(i);
			Element percent = percents.get(i);
			Element egg = eggs.get(i);
			System.out.println(rank.text() + ":" +title.text() + ":" + percent.text() + ":"+egg.text());
			
		
		}
			
		}

	
}