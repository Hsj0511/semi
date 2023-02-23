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
import board.VO.BoardVO2;
import board.service.BoardService;
import board.service.BoardService2;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/reviewPage2")
public class BoardController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController2() {
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
		

		
		
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		System.out.println( name +" ///" + content);
		
		BoardVO2 vo = new BoardVO2();
		
		vo.setName(name);
		vo.setContent(content);
		
		
		
		int result = new BoardService2().insertBoard(vo);
	     if(result < 1) {
      	   System.out.println("db가기 실패");
         } else {
      	   System.out.println("db가기 성공");
      	   response.sendRedirect(request.getContextPath()+ "/reviewPage2.jsp");
         }
         
		

	
	}
}
