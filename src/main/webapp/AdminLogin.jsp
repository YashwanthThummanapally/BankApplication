<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>
<body>
	<%
	String msg = (String)request.getAttribute("message");
	AdminBean admin = (AdminBean)session.getAttribute("abean");
	out.print(msg+"<br>"+"Welcome Admin "+admin.getFirstName()+"<br>");
	%>
	<a href="customer.html">AddCustomer</a><br>
	<a href="viewallcust">ViewAllCustomers</a><br>
	<a href="transaction">ViewTransactionDetails</a><br>
	<a href="logoutadmin">Logout</a>	
</body>
</html>