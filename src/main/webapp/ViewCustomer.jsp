<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.AdminBean,test.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	AdminBean admin = (AdminBean)session.getAttribute("abean");
	CustomerBean cust = (CustomerBean)request.getAttribute("cbean");
	out.print("Page belongs to "+admin.getFirstName()+"<br>");
	if(cust==null) {
		out.print("Customer Not Available!<br>");
	}else {
		out.print(cust.getAccountNumber()+"&nbsp;&nbsp;&nbsp;&nbsp;"+cust.getHolderName()+"&nbsp;&nbsp;&nbsp;&nbsp;"+cust.getBalance()+"&nbsp;&nbsp;&nbsp;&nbsp;"+cust.getAccountType()+"&nbsp;&nbsp;&nbsp;&nbsp;"+"<a href='deletecust?accno="+cust.getAccountNumber()+"'>delete</a><br>");
	}
	%>
	<a href="customer.html">AddCustomer</a><br>
	<a href="viewallcust">ViewAllCustomers</a><br>
	<a href="accountno.html">ViewCustomerByAccNo</a><br>
	<a href="transaction">ViewTransactionDetails</a><br>		
	<a href="logoutadmin">Logout</a>
</body>
</html>