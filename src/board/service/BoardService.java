package board.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import board.DAO.BoardDAO;
import board.VO.BoardVO;
import common.JDBCTemplate;

public class BoardService {



	public int insertBoard(BoardVO vo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDAO().insertData(conn, vo);
		close(conn);
		System.out.println("service 연결됨");
		return result;
	}


}
