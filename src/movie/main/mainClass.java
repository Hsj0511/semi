package movie.main;

import java.util.ArrayList;

import movie.crawling.crawlingClass;
import movie.dao.dbDAO;
import movie.vo.movieVO;



public class mainClass {

	public static void main(String[] args) {
		ArrayList<movieVO> ML = new ArrayList<movieVO>();
		crawlingClass.Crawling(ML);
		
		dbDAO.UploadToDB(ML);
		dbDAO.DownloadToDB(ML);
	}

}
