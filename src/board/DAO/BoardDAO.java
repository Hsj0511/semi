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
	
	public int getIndex() {
		int maxNum =0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		try {
			String sql = " select nvl(max(num),0) from review1 ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				maxNum = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxNum;
	}

	public int insertReview( BoardVO vo) {
		int result = 0;
		
		String sql = " insert into review1 (num, name, content, postdate) "
		            + "values(?,?,?, sysdate)";
		
		
		PreparedStatement pstmt = null;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getNum());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getContent());
		
		
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("디비 입력 성공");
		return result;
		
	}


	
	
	
}
