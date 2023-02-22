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
<link rel="stylesheet"  href="${pageContext.request.contextPath}/src/style/MainCss.css">
<link rel="stylesheet"  href="<%=request.getContextPath() %>../css/MainCss.css">
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
 margin-right:auto;
 padding: 20px;
}
table, td, th {
    border-collapse : collapse;
};

</style>







</head>
<body>


<div>

 예매율 순으로 보기
</div>

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
  if(rs.getString("title").equals("앤트맨과 와스프-퀀텀매니아")) {
%>

	<tr >
		<td class="rank"><%=rs.getString("RANK") %></td>
    	<td><a href="http://localhost:8090/semi/reviewPage1.jsp"><img src="<%=rs.getString("IMGURL")%>"  height="280" width="200"></a></td>
    	<td class="title"><%=rs.getString("TITLE") %></td>
		<td class="egg">에그지수 <%=rs.getString("EGG") %></td>
		<td class="percent">예매율 <%=rs.getString("PERCENT") %></td>
	</tr>


<%
  } else if(rs.getString("title").equals("서치 2")) {
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