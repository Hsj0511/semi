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

import movie.vo.CarVo;
import movie.vo.MovieVO;



public class crawlingCar {

	public static void Crawling(ArrayList<CarVo> CL) {
		
		String url = "https://auto.daum.net/newcar/brand/bde0000600fm";
		
		
		Document doc = null;;

	try {
		doc = Jsoup.connect(url).get();
	} catch (Exception e) {
		e.printStackTrace();
	}

		Elements carnames = doc.select("ul.list_lineup >div.cont_thumb > strong");
		Elements infos = doc.select("dl.info_thumb > dd.data_price");
		Elements imgs= doc.select("dl.info_thumb dd");
		
			
			for (int i =0; i<2; i++) {
				String carname = carnames.get(i).text();
				String info = infos.get(i).text();				
				String img = imgs.get(i).text();

			
			     	 CL.add(new CarVo(carname,info,img));
			     	 System.out.println("크롤링 성공!");
			     	 System.out.println("carname: " + carname);
			     	 System.out.println("가격: " + info);
			     	 System.out.println("img: " + img);
				}
		}
			
		//	System.out.println(" 디비 저장 데이터 :"+  ML);

	}

