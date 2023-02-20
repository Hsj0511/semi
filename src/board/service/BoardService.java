package board.service;

import java.sql.Connection;

import board.DAO.BoardDAO;
import board.VO.BoardVO;
import static movie.dao.DbDAO.*;

public class BoardService {

	public int insertReview(BoardVO vo) {
		int result = 0;
		Connection conn = getConnection();
		result = new BoardDAO().insertReview(conn, vo);
		close(conn);
		return result;
	}

}
