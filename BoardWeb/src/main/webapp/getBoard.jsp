<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.globalin.biz.board.impl.BoardDAO"%>
<%@ page import="com.globalin.biz.board.BoardVO"%>

<%
BoardVO board = (BoardVO)session.getAttribute("board");
// 3. 응답 화면 구성
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
</head>
<body>
	<div align="center">
		<h1>글 상세보기</h1>
		<a href="logout.do">Logout</a>
		<hr color="red">
		
		<form action="updateBoard.do" method="post">
			<input type="hidden" name="seq" value="<%=board.getSeq() %>">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">제목</td>
					<td align="left"><input type="text" name="title" value="<%=board.getTitle() %>"></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left"><%=board.getWriter() %></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left">
						<textarea rows="10" cols="40" name="content"><%=board.getContent() %></textarea>
					</td>
				</tr>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left"><%=board.getRegDate() %></td>
				</tr>
				<tr>
					<td bgcolor="orange">조회수</td>
					<td align="left"><%=board.getCnt() %></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글수정">
					</td>
				</tr>
			</table>
		</form>
		<hr color="red">
		<a href="insertBoard.do">글등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard.do?seq=<%=board.getSeq() %>">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do">글목록</a>&nbsp;&nbsp;&nbsp;
	</div>
</body>
</html>