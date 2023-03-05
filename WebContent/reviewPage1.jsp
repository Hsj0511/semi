<%@page import="movie.vo.MovieVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

<title>상세 리뷰 페이지</title>


<style type="text/css">




div.img {
float: left;
}
div.content{
float: right;
margin-right:70px;
}
div.img {
  padding-left: 30px;

}

body {
	margin-top: 20px;
	margin-left: 20px;
	margin-right: 20px;
	margin-bottom: 30px;
}


</style>
</head>
<body>

<button type="button" class="btn btn-outline-secondary" onclick="location.href='/semi/MainPage.jsp'">홈으로 가기</button>

<div class="logo" style=height:70px;>
<br>

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




<div class="img" style="text-align : center;">
<img src="https://img.cgv.co.kr/Movie/Thumbnail/Poster/000086/86796/86796_320.jpg" height="700">
</div>

<div class="content">


<%
	Class.forName("oracle.jdbc.OracleDriver");
	
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MOVIE", "MOVIE");
	
	String sql = "select * from review1  order by num desc" ;
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery(sql);
%>
<div>


<div class="mb-3">
<form action="reviewPage1" method="post" name="insert_Data">
  <label for="exampleFormControlInput1" class="form-label">닉네임</label>
  <input type="text" class="form-control" name="name" placeholder="닉네임">
</div>

<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">리뷰를 등록하세요</label>
  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="content"></textarea>
   <button type="submit">등록하기</button>
  
</form>

</div>

<hr>






<section>

<table class="table" >
	<tr class="table-light">
		<th class="num" scope="col">글번호</th>
		<th class="name" scope="col">닉네임</th>
		<th scope="col">리뷰내용</th>
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
</div>



</body>
</html>