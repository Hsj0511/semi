<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<%@ page import="java.util.Date" %>
<title>1번영화 리뷰 페이지</title>
</head>
<body>



<div class="insertData">
	<form action="reviewPage1" method="post" name="insert_Data">
		닉네임: <input type="text" name="boardWriter">
	<br>
	    
		리뷰를 남겨주세요: <input type="text" name="boardContent">
	<br>

	    <button type="submit">등록하기</button>


	</form>
</div>



<div class="showReview">

</div>

</body>
</html>