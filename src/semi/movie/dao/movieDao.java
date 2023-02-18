package semi.movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;

import semi.common.jdbc.JDBCTemplate;
import semi.movie.vo.movieVo;

public class movieDao {



//	public int insertData(Element rank, Element title, Element percent, Element egg) {
//		String sql = "INSERT INTO MOVIE (rank, title, percent, egg) VALUES ('"+rank+"','"+title+"','"+percent+"','"+egg+")";
//				
//        System.out.println(sql);
//        
//        Connection conn = getConnection();
//        Statement stmt = null;
//        int count=0;
//        
//        try {
//			stmt = conn.createStatement();
//			count = stmt.executeUpdate(sql);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(stmt != null) {
//					stmt.close();
//				}
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//        
//		return count;
//	}


}
