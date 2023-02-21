package board.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.VO.BoardVO;
import board.service.BoardService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/reviewPage1")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("영화1 리뷰 포스트");
		

		
		
		String boardWriter = request.getParameter("boardWriter");
		String boardContent = request.getParameter("boardContent");
		Timestamp boardDate = new Timestamp(System.currentTimeMillis());
		BoardVO vo = new BoardVO();
		System.out.println(boardDate);


	
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MOVIE","MOVIE");
			System.out.println("리뷰 디비 접속 성공!");
			
			
			vo.setBoardWriter(boardWriter);
			vo.setBoardContent(boardContent);
		//	vo.setBoardDate(boardDate);
		

			
			Statement stmt = conn.createStatement();
			String sql =" insert into review1 (boardSeq, boardWriter, boardContent, boardDate)" +
			           " values (review1_seq.nextval, '"+boardWriter+"','"+boardContent+"','"+boardDate+"') ";
			
			stmt.executeUpdate(sql);
			
			
			System.out.println("리뷰 insert 성공");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("리뷰 디비 접속 실패");
    	} catch (ClassNotFoundException e) {
			e.printStackTrace();
	   } finally {
		   response.sendRedirect(request.getContextPath()+ "/reviewPage1");
	   }
	}

}
