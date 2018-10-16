<%@page import="kr.co.psw.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	BoardVO vo = (BoardVO) request.getAttribute("vo");
%>
<table>
	<tr>
		<th class="bid">등록번호</th>
		<th class="btitle">제목</th>
		<th class="bregdate">등록일시</th>
	</tr>
	<tr>
		<td><%=vo.getBid()%></td>
		<td><%=vo.getBtitle()%></td>
		<td><%=vo.getBregdate()%></td>
	</tr>
	<tr>
		<th colspan="3">글내용</th>
	</tr>
	<tr>
		<td colspan="3"><%=vo.getBcontent()%></td>
	</tr>
</table>
<p class="p1">
	<a href="insertPage.bo?btype=${btype}&bid=${bid}">수정</a> <a
		href="boardDelete.bo?btype=${btype}&bid=${bid}">삭제</a> <a
		href="boardList.bo?btype=${btype}">목록</a>
</p>