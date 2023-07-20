<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.order"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>my Cart</title>
<link rel="stylesheet" href="./commonStyles/common-styles.css" />
<link rel="stylesheet" href="./css/Home.css" />
<script src="./commonStyles/common-scripts.js" defer></script>
</head>
<style>
td, th {
	border: 1px solid #dddddd;
	text-align: center;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<%
	String email = null;
	if (session.getAttribute("email") == null) {
		email = (String) session.getAttribute("email");
		response.sendRedirect("login.jsp");
	}
	%>
	<section class="header-container">
		<div class="header">
			<div class="navbar">
				<div class="nav-container">
					<div class="logo">
						<img src="./images/logo.png" alt="logo" loading="lazy" />
					</div>
					<div id="menuToggle">
						<input type="checkbox" /> <span id="span1"></span> <span
							id="span2"></span> <span id="span3"></span>
					</div>
					<div class="navbar-links">
						<ul>
							<li><a href="home.jsp">Home</a></li>
							<li class="navLinks"><a
								href="getProducts?msg=${email}&category=cakes">Cakes</a></li>
							<li class="navLinks"><a
								href="getProducts?msg=${email}&category=minibites">Mini
									Bites</a></li>
							<li class="navLinks"><a href="About-Us.jsp">About Us</a></li>
							<li class="navLinks"><a href="getCart?msg=${email}">MyCart</a></li>
							<li class="navLinks"><a href="Contact-Us.jsp">Contact Us</a></li>
							<li>
								<form action="logout">
									<button class="btn"border-radius:10px;">
										<span>LogOut</span></a>
									</button>
								</form>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="cartItems" style="background-color: white">
			<%
			List<order> lst = (List<order>) session.getAttribute("allOrders");
			%>
			<table style="width: 100%;">
				<tr style="text-align: center">
					<th>Order Id</th>
					<th>Email</th>
					<th>Payment Mode</th>
					<th>TransactionId</th>
					<th>Order Details</th>					
					<th>Order Date</th>
					<th>Status</th>
				</tr>
				<%
				for (order o : lst) {
				%>
				<tr>
					<td><%=o.getOrderId()%></td>
					<td><%=o.getCustId()%></td>
					<td><%=o.getPaymentMode()%></td>
					<td><%=o.getTransactionId()%></td>
					<td><a href="orderDetails?orderId=<%=o.getOrderId()%>&email=<%=o.getCustId()%>">Click here</a></td>					
					<td><%=o.getOrderDate()%></td>
					<td><%=o.getStatus()%></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</section>


</body>
</html>