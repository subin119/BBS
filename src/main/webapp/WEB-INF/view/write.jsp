<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 작성</title>
</head>
<body>
	<h3>글을 작성하세요!</h3>
	<hr>
	<form name="textForm" method="post" action="/BbsMVC/add">
	작성자 : <input type="text" name="createrName" style="width:300px" placeholder="작성자 이름을 입력해주세요"><br/>
	글 제목 : <input type="text" name="title" style="width:500px" placeholder="게시글 제목을 입력해주세요"><br/>
	쓰기 : <textarea name="content" style="width:500px; height:300px"></textarea><br/>
	<input type="submit" value="글 등록">
	</form>
	
	<form method="post" action="/BbsMVC/bbsList">
	<input type="submit" value="HOME">
	</form>
	
</body>
</html>