package movie.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import movie.vo.movieVO;


public class crawlingClass {

	public static void Crawling(ArrayList<movieVO> ML) {
		
		String url = "http://www.cgv.co.kr/movies/?lt=1&ot=1";
		
		
		Document doc = null;;

	try {
		doc = Jsoup.connect(url).get();
	} catch (Exception e) {
		e.printStackTrace();
	}

		Elements ranks = doc.select("div.box-image strong.rank");
		Elements titles = doc.select("div.box-contents strong.title");
		Elements percents = doc.select("div.box-contents > div.score > strong.percent > span");
		Elements eggs = doc.select("div.box-contents > div.score > div.egg-gage.small > span.percent");
		for (int i = 0; i < 19; i++) {
			String rank =ranks.get(i).text();
			String title = titles.get(i).text();
			String percent = percents.get(i).text();
			String egg = eggs.get(i).text();
	
		ML.add(new movieVO(rank, title, percent, egg));
	}
		System.out.println("크롤링 성공!");
		System.out.println(ML);
	}

}
