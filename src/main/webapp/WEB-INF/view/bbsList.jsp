<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BBS</title>
</head>
<body>
	<h1>Bulletin Board System</h1>
	<br/>
	<table style="width:100%;  border: 1px solid #000000; background-color: #47C83E">
		<tr style="height: 50px; color: #FFFFFF">
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>추천수</th>
			<th>생성일</th>
		</tr>
		
		<c:forEach items="${bbses}" var="bbses">
		<tr style="height: 20px; text-align: center; background-color: #9FC93C">
			<td>${bbses.getBbsId()}</td>
			<td><a href="/BBS/detail?bbsId=${bbses.getBbsId()}" style="text-decoration:none">
				${bbses.getTitle()}</a></td>
			<td>${bbses.getCreaterName()}</td>
			<td>${bbses.getHitCount()}</td>
			<td>${bbses.getRecommendCount()}</td>
			<td>${bbses.getCreatedDate()}</td>
		</tr>		
		</c:forEach>
		
	</table><hr/>
	<form method="post" action="./write">
	<input type="submit" value="글쓰기">
	</form>
</body>
</html>