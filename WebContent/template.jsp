<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>박성우 게시판</title>
</head>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/${template}.css">
<body>
	<jsp:include page="top.jsp" />
	<div class="content">
		<jsp:include page="${template}.jsp" />
	</div>
	<jsp:include page="bottom.jsp" />
</body>
</html>