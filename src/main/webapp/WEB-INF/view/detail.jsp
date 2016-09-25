<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세보기</title>
</head>
<body>
	<h1>${bbs.getTitle()}</h1>
	<hr/>
	<h3>작성자 : ${bbs.getCreaterName()}</h3>
	<h3>입력 시간 : ${bbs.getCreatedDate()}</h3>
	<h3>조회수 : ${bbs.getHitCount()}</h3>
	<hr/>
	<p>
		내용 : ${bbs.getContet()}
	</p>
	<a href="/BbsMVC/delete?bbsId=${bbs.getBbsId()}">글 삭제</a>
	<a href="/BbsMVC/bbsList">처음으로</a>
	</body>
</html>