package movie.main;

import java.util.ArrayList;

import movie.crawling.crawlingClass;
import movie.dao.DbDAO;
import movie.vo.MovieVO;



public class MainClass {

	public static void main(String[] args) {
		ArrayList<MovieVO> ML = new ArrayList<MovieVO>();
		crawlingClass.Crawling(ML);
		
		DbDAO.UploadToDB(ML);
		DbDAO.DownloadToDB(ML);
	}

}
