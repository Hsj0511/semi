<%@page import="movie.vo.MovieVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>


<%

	Class.forName("oracle.jdbc.OracleDriver");
	
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MOVIE", "MOVIE");
	
	String sql = "select * from movieinfo";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery(sql);
	ArrayList<MovieVO> ML = new ArrayList<MovieVO>();

%>

<table>
	<tr>
		<th>랭킹</th>
		<th>포스터</th>
		<th>영화제목</th>
		<th>예매율</th>
		<th>에그지수</th>
		
	</tr>

<tr>

<%
while(rs.next()) {
  if(rs.getString("RANK").equals("No.1")) {
%>

	<tr>
		<td><%=rs.getString("RANK") %></td>
    	<td><a href="http://localhost:8090/semi/reviewPage1.jsp"><img src="<%=rs.getString("IMGURL")%>"  height="280" width="200"></a></td>
    	<td><%=rs.getString("TITLE") %></td>
		<td><%=rs.getString("PERCENT") %></td>
		<td><%=rs.getString("EGG") %></td>
	</tr>
<%
  } else {
%>
	<tr>
		<td><%=rs.getString("RANK") %></td>
	    <td><img src="<%=rs.getString("IMGURL")%>" height="280" width="200"></td>
	    <td><%=rs.getString("TITLE") %></td>
		<td><%=rs.getString("PERCENT") %></td>
		<td><%=rs.getString("EGG") %></td>
	</tr>
<%
  }
}
%>



</body>
</html>