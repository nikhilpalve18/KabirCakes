<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.orderDetails"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta charset="ISO-8859-1">
<title>Cake Shop Invoice</title>
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
	%>
	<header>
		<h1>Kabir Cakes</h1>
		<p>Shriram Chowk, Ahmednagar</p>
		<p>Phone: +91-9087778887</p>
		<p>Email: kabircakes@gmail.com</p>
	</header>
	<main>
		<h2>Invoice</h2>
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
		<div id="printButton">
			<button onclick="window.print();return false;">Print</button>
			<button><a href="home.jsp" style="text-decoration:none; color:black">Home</a></button>
		</div>
		<p>Thank you for your business!</p>
	</main>
</body>
</html>
