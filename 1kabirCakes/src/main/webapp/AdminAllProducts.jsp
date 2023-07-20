<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.product"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/Home.css">
<link rel="stylesheet" href="./commonStyles/common-styles.css">
<script src="./commonStyles/common-scripts.js" defer></script>
<title>View</title>
<!-- <link rel="stylesheet" href="style.css" /> -->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<style>
@import
	url('https://fonts.googleapis.com/css2?family=Roboto:ital@1&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	width: 100%;
	display: flex;
	justify-content: center;
	font-family: 'Roboto', sans-serif;
	background-color: #adacac;
}

table {
	width: 100%;
	border-collapse: collapse;
}

.header_fixed {
	max-height: 100vh;
	width: 100%;
	overflow: auto;
	border: 1px solid #dddddd;
}

.header_fixed thead th {
	position: sticky;
	top: 0;
	background-color: black;
	color: #e6e7e8;
	font-size: 15px;
}

th, td {
	border-bottom: 1px solid #dddddd;
	padding: 10px 20px;
	font-size: 14px;
	text-align: center;
}

td img {
	height: 100px;
	width: 100px;
	border: 5px solid #e6e7e8;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

tr:nth-child(odd) {
	background-color: #edeef1;
}

tr:hover td {
	color: #44b478;
	cursor: pointer;
	background-color: #ffffff;
}

td button {
	border: none;
	padding: 7px 20px;
	border-radius: 20px;
	background-color: black;
	color: #e6e7e8;
}

::-webkit-scrollbar {
	width: 6px;
}
</style>

</head>

<body>


	<div class="header_fixed">
		<div class="navbar">
			<div class="nav-container" style="width: 100%">
				<div class="logo">
					<img src="./images/logo.png" alt="logo" loading="lazy"
						style="height: 8rem; position: relative left:50px">
				</div>
				<div id="menuToggle">
					<input type="checkbox" /> <span id="span1"></span> <span
						id="span2"></span> <span id="span3"></span>
				</div>
				<div class="navbar-links">
					<ul>
						<li class="navLinks"><a href="addProducts.jsp">Add
								Products</a></li>
						<li class="navLinks"><a
							href="getProducts?msg=${email}&category=adminView">All
								Products</a></li>
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



		<table>
			<thead>
				<tr>
					<th>Sr.No</th>
					<th>Image</th>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<product> lst = (List<product>) session.getAttribute("Allproducts");
				int srNo = 0;
				for (product p : lst) {
					srNo++;
				%>
				<tr>
					<td><%=srNo%></td>
					<td><img src="./images/<%=p.getImageFileName()%>"></td>
					<td><%=p.getProdName()%></td>
					<td><%=p.getProdDesc()%></td>
					<td><%=p.getProdPrice()%></td>
					<td>
						<button>
							<a href="editProduct?msg=<%=p.getProdId()%>">Edit</a>
						</button>
						<button>
							<a href="deleteProduct?msg=<%=p.getProdId()%>">Delete</a>
						</button>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>