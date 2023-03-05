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
  <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>영화 리뷰 모아</title>





<style>
@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);

h1{
     font-family: 'Nanum Pen Script', cursive;
}

 tbody td:nth-child(1) {
    background-color:orangered;
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

<div class="logo" style=height:70px;>
<hr>

<nav class="navbar" style="background-color: #FFE4E1;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-boombox-fill" viewBox="0 0 16 16">
  <path d="M14 0a.5.5 0 0 1 .5.5V2h.5a1 1 0 0 1 1 1v2H0V3a1 1 0 0 1 1-1h12.5V.5A.5.5 0 0 1 14 0ZM2 3.5a.5.5 0 1 0 1 0 .5.5 0 0 0-1 0Zm2 0a.5.5 0 1 0 1 0 .5.5 0 0 0-1 0Zm7.5.5a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1Zm1.5-.5a.5.5 0 1 0 1 0 .5.5 0 0 0-1 0ZM9.5 3h-3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1ZM6 10.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0Zm-1.5.5a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1Zm7 1a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3Zm.5-1.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0Z"/>
  <path d="M0 6h16v8a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1V6Zm2 4.5a2.5 2.5 0 1 0 5 0 2.5 2.5 0 0 0-5 0Zm7 0a2.5 2.5 0 1 0 5 0 2.5 2.5 0 0 0-5 0Z"/>
</svg>
     영화 리뷰 모아
    </a>
  </div>
</nav>
</div>

<hr>
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