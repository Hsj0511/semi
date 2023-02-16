package semi.common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {

	public static Connection getConnection() {
		
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MOVIE","MOVIE");
			System.out.println("오라클");
			} catch (SQLException e) {
				System.out.println("드라이버 실패");
				e.printStackTrace();
	    	} catch (ClassNotFoundException e) {
 			e.printStackTrace();
 			System.out.println("오라클 실패");
		   }
		
		
		if(conn != null) System.out.println("DB연결 성공");
		else System.out.println("DB연결 실패");
		return conn;
	}

	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
			conn.close(); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}


	
	//commit
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//rollback
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
