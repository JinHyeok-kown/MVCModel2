<%@page import="kr.co.psw.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<BoardVO> list = (ArrayList<BoardVO>) request.getAttribute("list");
%>
<table>
	<tr>
		<th class="bid">순서</th>
		<th class="btitle">제목</th>
		<th class="bregdate">등록일자</th>
	</tr>

	<%
		for (BoardVO vo : list) {
	%>
	<tr>
		<td><%=vo.getBid()%></td>
		<td><a
			href="boardDetail.bo?btype=${btype}&bid=<%=vo.getBid()%>"><%=vo.getBtitle()%></a></td>
		<td><%=vo.getBregdate()%></td>
	</tr>
	<%
		}
	%>
</table>
<p class="p1">
	<a
		href="insertPage.bo?btype=${btype}&bid=0"
		class="a1">글쓰기</a>
</p>
<p class="p2">
	<%
		for (int i = 1; i <= (int) request.getAttribute("cnt"); i++) {
	%>
	<a
		href="boardList.bo?page=<%=i%>&btype=${btype}"><%=i%></a>&nbsp;
	<%
		}
	%>
</p>