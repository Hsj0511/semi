package semi.movie.service;

import java.sql.Connection;
import java.sql.SQLException;

import semi.common.jdbc.JDBCTemplate;

public class movieService {

	public int login(String rank) {
		int result = 0;
		Connection conn =  JDBCTemplate.getConnection();
		
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
