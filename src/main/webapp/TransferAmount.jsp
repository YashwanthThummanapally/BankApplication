<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	CustomerBean cust = (CustomerBean)session.getAttribute("cbean");
	String msg = (String)request.getAttribute("message");
	out.print("Page belongs to "+cust.getHolderName()+"<br>");
	out.print(msg+"<br>");
	%>
	<%@include file="application.html"%>
</body>
</html>