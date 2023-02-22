package movie.main;

import java.util.ArrayList;

import common.JDBCTemplate;
import movie.crawling.crawlingClass;
import movie.vo.MovieVO;



public class MainClass {

	public static void main(String[] args) {
		ArrayList<MovieVO> ML = new ArrayList<MovieVO>();
	//	crawlingClass.Crawling(ML);
		
	//	JDBCTemplate.UploadToDB(ML);
		JDBCTemplate.DownloadToDB(ML);
	
	}

}
