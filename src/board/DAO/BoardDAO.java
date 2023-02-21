package board.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import board.VO.BoardVO;
import static movie.dao.DbDAO.*;

public class BoardDAO {
	private Connection conn;
	public BoardDAO(Connection conn) {
		this.conn=conn;
	};
	
	public int insertData() {

	
		try {
			String sql = " insert into review1 values ((select nvl(max(num),0)+1 from review1), ? ,?, ? ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			pstmt.set
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
		
	}


	
	
	
}
