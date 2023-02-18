package semi;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import semi.common.jdbc.JDBCTemplate;

public class crawlingClass {

	public static void main(String[] args) throws IOException {
		
		String url = "http://www.cgv.co.kr/movies/?lt=1&ot=1";
		
	
		Document doc = Jsoup.connect(url).get();

		
		
		System.out.println("예매순");
		Elements ranks = doc.select("div.box-image strong.rank");
		Elements titles = doc.select("div.box-contents strong.title");
		Elements percents = doc.select("div.box-contents > div.score > strong.percent > span");
		Elements eggs = doc.select("div.box-contents > div.score > div.egg-gage.small > span.percent");
		for (int i = 0; i < 19; i++) {
			Element rank =ranks.get(i);
			Element title = titles.get(i);
			Element percent = percents.get(i);
			Element egg = eggs.get(i);
			System.out.println(rank.text() + ":" +title.text() + ":" + percent.text() + ":"+egg.text());
		
			
		
//	JDBCTemplate jt = new JDBCTemplate();
//	int count = jt.insertData(rank, title, percent, egg);
//	if(count > 0) {
//		System.out.println("추가 완료");
//	}
	
	
	
		
	
		
	}

	
}


}
