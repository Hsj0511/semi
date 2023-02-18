package semi.common.jdbc;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.jsoup.nodes.Element;






//현재 프로젝트와 오라클DB 계정 KH와 연결하고 그 결과 Connection을 만들어내기
public class JDBCTemplate {
 
	//리턴타입 없는 기본생성자
	private static JDBCTemplate instance;
	
	private JDBCTemplate() {} 
	
	public static JDBCTemplate getInstance() {
		if(instance == null ) {
			instance = new JDBCTemplate();
		}
		return instance;
	}
	
	public static  Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
 		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc jar 없음");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결실패");
			e.printStackTrace();
		} finally {
			if(conn == null) {
				System.out.println("....,엥");
			} else {
				System.out.println("db연결 성공!!");
			}
		}
		return conn;
	}

}
