<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="https://img.cgv.co.kr/Movie/Thumbnail/Poster/000086/86796/86796_320.jpg" alt="No.1" />
<section>
<%

Class.forName("oracle.jdbc.OracleDriver");

Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MOVIE", "MOVIE");

String sql = "select imgurl from movieinfo";
PreparedStatement pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery(sql);

%>

<table>
	<tr>
		<th>글번호</th>

	</tr>
	<%
	while(rs.next()) {
	%>

	<tr>

		<td><img src="<%=rs.getString("IMGURL") %>"></td>

	
	</tr>
		<%
			}
		%>


</table>


</section>








</body>
</html>