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
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>





<style>

div{
  border-radius: 40px;
  border: solid 1px gray;
  width: auto;
  height: 140px;
  font-size: 40px;
  text-align:center;
  line-height: 100px;
  height: 80px;
}

 tbody td:nth-child(1) {
    background-color:red;
    color: white;
    font-size: 20px;
    text-align:center;
    bold;
  }
   tbody td:nth-child(3) {
    font-size: 18px;
  }
   tbody td:nth-child(4) {
    font-size: 14px;
  }
   tbody td:nth-child(5) {
    font-size: 14px;
  }
  
 tr { 
  display: block; float: left; 
  padding: 20px;
   
  
  
 }
td { 
	display: block; 
	padding: 8px;

}


table {
font-family: monospace;
font-weight: bold;
margin-left:auto; 
 padding: 20px;
}


body {
	margin: 80px;
}
</style>







</head>
<body>

<!-- As a heading -->
<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <span class="navbar-brand mb-0 h1">   예매율 순으로 보기</span>
  </div>
</nav>


<%

	Class.forName("oracle.jdbc.OracleDriver");
	
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MOVIE", "MOVIE");
	
	String sql = "select * from movieinfo";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery(sql);
	ArrayList<MovieVO> ML = new ArrayList<MovieVO>();

%>



<table>

<tbody>


<%
while(rs.next()) {
  if(rs.getString("rank").equals("No.1")) {
%>

	<tr >
		<td class="rank"><%=rs.getString("RANK") %></td>
    	<td><a href="http://localhost:8090/semi/reviewPage1.jsp"><img src="<%=rs.getString("IMGURL")%>"  height="280" width="200"></a></td>
    	<td class="title"><%=rs.getString("TITLE") %></td>
		<td class="egg">에그지수 <%=rs.getString("EGG") %></td>
		<td class="percent">예매율 <%=rs.getString("PERCENT") %></td>
	</tr>


<%
  } else if(rs.getString("rank").equals("No.2")) {
	%>
	<tr >
		<td class="rank"><%=rs.getString("RANK") %></td>
    	<td><a href="http://localhost:8090/semi/reviewPage2.jsp"><img src="<%=rs.getString("IMGURL")%>"  height="280" width="200"></a></td>
    	<td class="title"><%=rs.getString("TITLE") %></td>
		<td class="egg">에그지수 <%=rs.getString("EGG") %></td>
		<td class="percent">예매율 <%=rs.getString("PERCENT") %></td>
	</tr>
<%
  } else {
%>
	<tr>
		<td class="rank"><%=rs.getString("RANK") %></td>
	    <td><img src="<%=rs.getString("IMGURL")%>" height="280" width="200"></td>
	    <td class="title"><%=rs.getString("TITLE") %></td>
		<td class="egg">에그지수 <%=rs.getString("EGG") %></td>
		<td class="percent">예매율 <%=rs.getString("PERCENT") %></td>
	</tr>
<%
  }
}
%>
</tbody>
</table>


</body>
</html>