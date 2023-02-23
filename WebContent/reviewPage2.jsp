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

<title>서치 2 리뷰 페이지</title>


<style type="text/css">

div {
margin: auto;
text-align: center;

}

div.mb-3 {
padding-bottom:80px;
}
div.img {
  padding: 50px;
}

body {
	margin: 80px;
}

</style>
</head>
<body>

<nav class="navbar fixed-top bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/semi/MainPage.jsp">홈으로 가기</a>
  </div>
</nav>


<div class="img" style="text-align : center;">
<img src="https://img.cgv.co.kr/Movie/Thumbnail/Poster/000086/86770/86770_320.jpg" height="700">
</div>

<link href="/resources/css/MainCss.css" >

<%
	Class.forName("oracle.jdbc.OracleDriver");
	
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MOVIE", "MOVIE");
	
	String sql = "select * from review2 order by num desc";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery(sql);
%>




<div class="mb-3">
<form action="reviewPage2" method="post" name="insert_Data">
  <label for="exampleFormControlInput1" class="form-label">닉네임</label>
  <input type="text" class="form-control" name="name" placeholder="닉네임">
</div>

<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">리뷰를 등록하세요</label>
  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="content"></textarea>
   <button type="submit">등록하기</button>
  
</form>

</div>







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



</body>
</html>