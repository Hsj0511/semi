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
		

		
		
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		System.out.println( name +" ///" + content);
		
		BoardVO vo = new BoardVO();
		
		vo.setName(name);
		vo.setContent(content);
		
		
		
		int result = new BoardService().insertBoard(vo);
	     if(result < 1) {
      	   System.out.println("db가기 실패");
         } else {
      	   System.out.println("db가기 성공");
      	   response.sendRedirect(request.getContextPath()+ "/reviewPage1.jsp");
         }
         
		

	
	}
}
