<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Displaying Grade</h1>
	<%
		int java = Integer.parseInt(request.getParameter("java"));
		int dsa = Integer.parseInt(request.getParameter("dsa"));
		int python = Integer.parseInt(request.getParameter("python"));
		int cpp = Integer.parseInt(request.getParameter("cpp"));
		int mcad = Integer.parseInt(request.getParameter("mcad"));
		
		int sum = java + dsa + python + cpp + mcad;
		double average = sum/5;
		
		out.print("Your Grade is:");
		if(average > 90) {
			out.print("A");
		}
		else if(average >= 80){
			out.print("B");
		}
		else if(average >= 70){
			out.print("C");
		}
		else if(average >= 60){
			out.print("D");
		}
		else{
			out.print("F");
		}
	%>
</body>
</html>