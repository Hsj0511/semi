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

<section>
<%

Class.forName("oracle.jdbc.OracleDriver");

Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MOVIE", "MOVIE");

String sql = "select * from movieinfo";
PreparedStatement pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery(sql);

%>
<table>
	<tr>
		<th>랭킹</th>
		<th>포스터</th>
		<th>영화제목</th>
		<th>예매율</th>
		<th>에그지수</th>
		
	</tr>


	<%
	while(rs.next()) {
	%>

	<tr>
		<td><%=rs.getString("RANK") %></td>
		<td><img src="<%=rs.getString("IMGURL") %>"></td>
		<td><%=rs.getString("TITLE") %></td>
		<td><%=rs.getString("PERCENT") %></td>
		<td><%=rs.getString("EGG") %></td>
	</tr>
		<%
			}
		%>





</section>








</body>
</html>