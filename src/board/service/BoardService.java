package board.service;

import java.sql.Connection;

import board.DAO.BoardDAO;
import board.VO.BoardVO;
import movie.dao.DbDAO;

import static movie.dao.DbDAO.*;

public class BoardService {



	public int insertBoard(BoardVO vo) {
		int result = -1;
		Connection conn = DbDAO.getConnection();
		result = new BoardDAO().insertData(conn, vo);
		close(conn);
		System.out.println("service 연결됨");
		return result;
	}


}
