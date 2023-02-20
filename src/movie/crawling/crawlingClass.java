package movie.crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import movie.vo.MovieVO;



public class crawlingClass {

	public static void Crawling(ArrayList<MovieVO> ML) {
		
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
		Elements imgs= doc.select("div.box-image ").tagName("img");
			
			for (int i =0; i<19; i++) {
				String rank =ranks.get(i).text();
				String title = titles.get(i).text();
				String percent = percents.get(i).text();
				String egg = eggs.get(i).text();
				
				Element img = imgs.get(i);
				String imgPath = String.valueOf(img);

				String targetTextString=imgPath;
				Pattern pattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
				Matcher matcher = pattern.matcher(targetTextString);
				
				while(matcher.find()) {
					  String path = matcher.group(1).substring(0, matcher.group(1).lastIndexOf("/") + 1);
					  String savedName = matcher.group(1).substring(matcher.group(1).lastIndexOf("/") + 1);
					String imgurl = path+savedName;
					  

			     	 ML.add(new MovieVO(rank, title, percent, egg, imgurl));
				}
		}
			System.out.println("크롤링 성공!");
		//	System.out.println(" 디비 저장 데이터 :"+  ML);

	}
}
