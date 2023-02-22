package movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import movie.vo.MovieVO;

public class DbDAO {

	public static Connection getConnection() {

		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MOVIE", "MOVIE");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (conn != null)
			System.out.println("DB연결 성공");
		else
			System.out.println("DB연결 실패");
		return conn;
	}

	public static void UploadToDB(ArrayList<MovieVO> ML) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "MOVIE";
		String pw = "MOVIE";
		Connection conn;
		String sql;
		MovieVO result = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			if (conn != null) {
				System.out.println("접속성공!!!!!!");
			}
			for (int j = 0; j < ML.size(); j++) {
				sql = " INSERT INTO MOVIEINFO(RANK, TITLE, PERCENT, EGG, IMGURL) VALUES (?, ?, ?, ? ,?) ";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ML.get(j).getRank());
				pstmt.setString(2, ML.get(j).getTitle());
				pstmt.setString(3, ML.get(j).getPercent());
				pstmt.setString(4, ML.get(j).getEgg());
				pstmt.setString(5, ML.get(j).getImgurl());
				pstmt.executeUpdate();
			}
			System.out.println("디비 저장 성공!!!!!");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static void DownloadToDB(ArrayList<MovieVO> ML) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "MOVIE";
		String pw = "MOVIE";
		Connection conn;
		String sql;

		String RT, TT, PT, ET, IT;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			if (conn != null) {
				System.out.println("접속 성공!!");
			}
			sql = " SELECT * FROM MOVIEINFO ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				RT = rs.getString("rank");
				TT = rs.getString("TITLE");
				PT = rs.getString("PERCENT");
				ET = rs.getString("EGG");
				IT = rs.getString("IMGURL");
				ML.add(new MovieVO(RT, TT, PT, ET, IT));
			}
			System.out.println("다운 성공!!");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// commit
	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// rollback
	public static void rollback(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
