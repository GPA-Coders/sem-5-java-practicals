<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String n = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		out.println("Your Name is:" + n);
		out.println("<br>");
		out.println("Your Password is:" + pwd);
	%>
</body>
</html>