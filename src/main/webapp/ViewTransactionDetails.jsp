<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.AdminBean,test.TransactionBean,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	AdminBean admin = (AdminBean)session.getAttribute("abean");
	ArrayList<TransactionBean> transactions = (ArrayList<TransactionBean>)session.getAttribute("tlist");
	if(transactions.size()==0){
		out.print("No Transactions yet!");
	}else{
		Iterator<TransactionBean> itr = transactions.iterator();
		out.print("Page belongs to "+admin.getFirstName()+"<br>");
	%>
	<table border="1">
		<tr>
			<th>TransactionID</th>
			<th>HomeAccount</th>
			<th>BeneficieryAccount</th>
			<th>Amount</th>
			<th>Time</th>
		</tr>
		<%
			while(itr.hasNext()) {
				TransactionBean transaction = itr.next();
		%>
		<tr>
			<td><%out.print(transaction.getTransactionId());%></td>
			<td><%out.print(transaction.getHomeAccountNumber());%></td>
			<td><%out.print(transaction.getBeneficieryAccountNumber());%></td>
			<td><%out.print(transaction.getAmount());%></td>
			<td><%out.print(transaction.getTime().toString());%></td>
		</tr>
		<%
				}
			}
		%>
	</table>
	<a href="customer.html">AddCustomer</a><br>
	<a href="viewallcust">ViewAllCustomers</a><br>
	<a href="transaction">ViewTransactionDetails</a><br>	
	<a href="logoutadmin">Logout</a>
</body>
</html>