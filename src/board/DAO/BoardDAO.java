package board.DAO;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.VO.BoardVO;

public class BoardDAO {
	
	
	Connection conn = getConnection();

	
	public int insertData(Connection conn, BoardVO vo) {
		int result = -1;
		PreparedStatement pstmt = null;
		
		String sql = "insert into review1 values ((select nvl(max(NUM+1),1) from review1),?,?)";
	
		try {
			
			
		
			pstmt = conn.prepareStatement(sql);
			
			//pstmt.setInt(1,1);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			
		
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		
			
	}
		System.out.println("DAO return : " + result);
		return result;

	
		
	}


	
	
	
}
