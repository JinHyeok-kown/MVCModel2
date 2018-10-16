<%@page import="kr.co.psw.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	BoardVO vo = (BoardVO) request.getAttribute("vo");
	if (request.getParameter("bid").equals("0")) {
%>
<form action="insertBoard.bo?btype=${btype}&bid=${bid}" method="post">
	<input type="hidden" name="btitle" class="btitle" placeholder="제목"><br><br>
	<textarea rows="10" cols="50" name="bcontent" class="bcontent" placeholder="내용"></textarea>
	<br> <input type="submit" value="글등록">
</form>
<%
	} else {
%>
<form action="insertBoard.bo?btype=${btype}&bid=${bid}" method="post">
	<input type="text" name="btitle" placeholder="<%=vo.getBtitle()%>" class="btitle"><br><br>
	<textarea rows="10" cols="50" name="bcontent"
		placeholder="<%=vo.getBcontent()%>" class="bcontent"></textarea>
	<br> <input type="submit" value="글등록">
</form>
<%
	}
%>