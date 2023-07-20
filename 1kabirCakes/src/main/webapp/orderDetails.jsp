<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.orderDetails"%>
<%@ page import="model.user"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta charset="ISO-8859-1">
<title>OrderDetails</title>
<style>
body {
	font-family: Arial, sans-serif;
}

header {
	text-align: center;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: left;
}

th {
	background-color: lightgray;
}

#printButton button {
	margin-top: 15px;
	padding: 3px 3px;
	width: 10%;
	text-align: center;
	position: relative;
	left: 40%;
}
</style>
</head>
<body>
	<%
	List<orderDetails> lst = (List<orderDetails>) session.getAttribute("orderDetails");
	List<user> lst1 = (List<user>) session.getAttribute("userDetails");
	orderDetails obj = lst.get(0);
	user u = lst1.get(0);
	%>
	<header>
		<h1>OrderID: <%=obj.getOrderId() %></h1>
		<h1>Email: <%=u.getEmail()%></h1>
		<p>Delivery Address: <%=u.getAddress()%>,<%=u.getCity()%>,<%=u.getState()%>, <%=u.getCountry()%></p>
		<p>Phone: <%=u.getMobileNumber()%></p>		
	</header>
	<main>
		<h2>OrderDetails</h2>
		<table>
			<tr>
				<th>Item</th>
				<th>Description</th>
				<th>Price</th>
				<th>subTotal</th>
			</tr>
			<%
			int srNo = 1;
			int total = 0;
			for (orderDetails o : lst) {
			%>
			<tr>
				<td><%=srNo++%></td>
				<td><%=o.getProdName()%></td>
				<td><%=o.getQuantity()%></td>
				<td><%=o.getSubtotal()%></td>
				<%
				total += o.getSubtotal();
				%>
			</tr>
			<%
			}
			%>
			<tr>
				<td colspan="3">Total</td>
				<td><%=total%></td>
			</tr>
		</table>
	</main>
</body>
</html>
