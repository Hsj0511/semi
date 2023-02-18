package movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import movie.vo.movieVO;

public class dbDAO {

	public static void UploadToDB(ArrayList<movieVO> ML) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "MOVIE";
		String pw = "MOVIE";
		Connection conn;
		String sql;
		movieVO result = null;
		ResultSet rs = null;
		
	
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pw);
			if(conn != null) {
				System.out.println("접속성공!!!!!!");
			}
			for(int j= 0; j <ML.size(); j ++) {
				sql=" INSERT INTO MOVIEINFO(RANK, TITLE, PERCENT, EGG) VALUES (?, ?, ?, ? ) ";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ML.get(j).getRank());
				pstmt.setString(2, ML.get(j).getTitle());
				pstmt.setString(3, ML.get(j).getPercent());
				pstmt.setString(4, ML.get(j).getEgg());
				pstmt.executeUpdate();
				}
			 System.out.println("디비 저장 성공!!!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	
		}
	
	public static void DownloadToDB(ArrayList<movieVO> ML) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "MOVIE";
		String pw = "MOVIE";
		Connection conn;
		String sql;
		
		String RT, TT, PT, ET;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pw);
			if (conn !=null) {
				System.out.println("접속 성공!!");
			}
			sql= " SELECT * FROM MOVIEINFO ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				RT = rs.getString("rank");
				TT = rs.getString("TITLE");
				PT = rs.getString("PERCENT");
				ET = rs.getString("EGG");
				ML.add(new movieVO(RT, TT, PT, ET));
			}
				System.out.println("다운 성공!!");
				
				
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) { 
			e.printStackTrace();
		}
		
	}
}
