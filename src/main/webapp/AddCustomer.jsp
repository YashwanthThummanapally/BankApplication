<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	AdminBean admin = (AdminBean)session.getAttribute("abean");
	String msg = (String)request.getAttribute("message");
	out.print("Page belongs to "+admin.getFirstName()+"<br>");
	out.print(msg+"<br>");
	%>
	<a href="customer.html">AddCustomer</a><br>
	<a href="viewallcust">ViewAllCustomers</a><br>
	<a href="transaction">ViewTransactionDetails</a><br>	
	<a href="logoutadmin">Logout</a>	
</body>
</html>