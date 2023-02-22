<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href ="<%=request.getContextPath() %>/resources/css/reset.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>

<title>1번영화 리뷰 페이지</title>
</head>
<body>



<div class="insertData">
	<form action="reviewPage1" method="post" name="insert_Data">
		닉네임: <input type="text" name="name">
	<br>
	    
		리뷰를 남겨주세요: <input type="text" name="content">
	<br>

	    <button type="submit">등록하기</button>


	</form>
</div>





<section>
<%

Class.forName("oracle.jdbc.OracleDriver");

Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MOVIE", "MOVIE");

String sql = "select * from review1" ;
PreparedStatement pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery(sql);

%>

<table>
	<tr>
		<th>글번호</th>
		<th>닉네임</th>
		<th>리뷰내용</th>
	</tr>
	<%
	while(rs.next()) {
	%>

	<tr>
	
		<td><%=rs.getInt("NUM") %></td>
		<td><%=rs.getString("NAME") %></td>
		<td><%=rs.getString("CONTENT") %></td>

	
	</tr>
		<%
			}
		%>


</table>


</section>



</body>
</html>