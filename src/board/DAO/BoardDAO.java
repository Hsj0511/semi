package board.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import board.VO.BoardVO;
import static movie.dao.DbDAO.*;

public class BoardDAO {

	public int insertReview(Connection conn, BoardVO vo) {
		int result = -1;
		
		String sql = " insert into review1 ?, ?, ?, ? ";
		
		
		PreparedStatement pstmt = null;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getBoardNum());
			pstmt.setString(2, vo.getBoardWriter());
			pstmt.setString(3, vo.getBoardContent());
			pstmt.setDate(4, vo.getBoardDate());
		
		result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("dao return:  " + result);
		return result;
		
	}


	
	
	
}
