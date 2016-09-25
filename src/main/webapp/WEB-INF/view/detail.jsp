<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세보기</title>
</head>
<body>
	<h1>${bbsVO.getTitle()}</h1>
	<hr/>
	<h4 style="color: #8B6E0E">작성자 : ${bbsVO.getCreaterName()}</h4>
	<h4 style="color: #8B6E0E">입력 시간 : ${bbsVO.getCreatedDate()}</h4>
	<h4 style="color: #8B6E0E">조회수 : ${bbsVO.getHitCount()}</h4>
	<hr/>
	<p>
		내용 : ${bbsVO.getContent()}
	</p><hr/>
	옵션<br/><br/>
	<form method="post" action="/BBS/delete?bbsId=${bbsVO.getBbsId()}" >
	<input type="submit" value="글삭제">
	</form>

	<form method="post" action="/BBS/recommend?bbsId=${bbsVO.getBbsId()}">
	<input type="submit" value="추천">
	</form>

	<form method="post" action="/BBS/bbsList">
	<input type="submit" value="HOME">
	</form>

	</body>
</html>