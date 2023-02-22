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
<meta charset="UTF-8">

<title>1번영화 리뷰 페이지</title>


<style type="text/css">

div {
margin: auto;
text-align: center;

}

.wrap { 
    width: 100%; 
    position: relative; 
   
}


div.header{
  margin-top: 20px;
  border-radius: 40px;
  border: solid 1px gray;
  width: auto;
  height: 140px;
  font-size: 40px;
  text-align:center;
  line-height: 100px;
  height: 80px;
}

div.img {
  padding: 50px;
}
div.insertData {
  padding-bottom:50px;
}
input {
  margin-top:10px;
  margin-bottom: 10px;
}

table {
 margin: auto;
 text-align:center;
 border: solid 1px gray;
 width: 800px;
 border-collapse: separate;
  border-spacing: 0 10px;
}

th.num {
width:60px;
}
th.name {
width:150px;
}


</style>
</head>
<body>
<button type="button" onclick="location.href='/semi/MainPage.jsp'">뒤로가기</button>

<div class="header">
리뷰 남기기
</div>

<div class="img" style="text-align : center;">
<img src="https://img.cgv.co.kr/Movie/Thumbnail/Poster/000086/86796/86796_320.jpg" height="700">
</div>

<%
	Class.forName("oracle.jdbc.OracleDriver");
	
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MOVIE", "MOVIE");
	
	String sql = "select * from review1" ;
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery(sql);
%>





<div class="insertData">
	<form action="reviewPage1" method="post" name="insert_Data">
		 <input type="text" placeholder="닉네임" name="name">
	<br>
	    
		 <input type="text" name="content"  placeholder="리뷰를 작성하세요." style="width:500px;height:200px;font-size:30px;">
	<br>

	    <button type="submit">등록하기</button>


	</form>


</div>


<section>

<table style="table-layout: fixed">
	<tr>
		<th class="num">글번호</th>
		<th class="name">닉네임</th>
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