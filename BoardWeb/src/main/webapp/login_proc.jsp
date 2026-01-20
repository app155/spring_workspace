<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.globalin.biz.user.impl.UserDAO" %>
<%@ page import="com.globalin.biz.user.UserVO" %>
<%
// 1. 사용자 입력정보 추출
String id = request.getParameter("id");
String password = request.getParameter("password");

// 2. DB 연동
UserVO vo = new UserVO();

vo.setId(id);
vo.setPassword(password);

UserDAO userDAO = new UserDAO();
UserVO user = userDAO.getUser(vo);

// 3. 화면 내비게이션
if (user != null) {
	response.sendRedirect("getBoardList.jsp");
}
else {
	response.sendRedirect("login.jsp");	
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>