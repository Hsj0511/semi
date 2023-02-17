package semi.common.jdbc;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
	
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		try {
	        String currpath = JDBCTemplate.class.getResource("./").getPath();
	        String filePath = currpath + "driver.properties";
			prop.load(new BufferedReader(new FileReader(new File(filePath))));
           
			System.out.println("1: " + prop.getProperty("lh.driver"));
            System.out.println("2: " + prop.getProperty("lh.url"));
            

            
            
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MOVIE", "MOVIE");
		
	
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		 catch (ClassNotFoundException e) {
			System.out.println("!!!!!!!ojdbc jar 없어요!!!!!!!!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("!!!!!!!연결실패!!!!!!!!");
			e.printStackTrace();
		} finally {
			if(conn == null) {
				System.out.println("!!!!!엥!!!!!");
			} else {
				System.out.println("연결성공");
			}
		}
		return conn;
	}
	
	
	//dao에, connection은 service에
	public int insertData(Element rank, Element title, Element percent, Element egg) {
		String sql = "INSERT INTO MOVIE (rank, title, percent, egg) VALUES ('"+rank+"','"+title+"','"+percent+"','"+egg+")";
				
        System.out.println(sql);
        
        Connection conn = getConnection();
        Statement stmt = null;
        int count=0;
        
        try {
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        


		return count;
	}
	
	


	public static void close(Connection conn) {
		try {
			if(conn !=null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
