package board.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import board.DAO.BoardDAO;
import board.DAO.BoardDAO2;
import board.VO.BoardVO;
import board.VO.BoardVO2;
import common.JDBCTemplate;

public class BoardService2 {



	public int insertBoard(BoardVO2 vo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDAO2().insertData(conn, vo);
		close(conn);
		System.out.println("service 연결됨");
		return result;
	}


}
