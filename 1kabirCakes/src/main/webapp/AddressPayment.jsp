<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./commonStyles/common-styles.css" />
<link rel="stylesheet" href="./css/register.css" />
<script src="./commonStyles/common-scripts.js" defer></script>
</head>
<body>
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
							href="getProducts?msg=${email}&category=minibites">Mini Bites</a></li>
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
	<div class="container">
		<div class="title">Enter the details..</div>
		<div class="content">
			<form action="AddPayCont" method="post">
				<div class="user-details">
					<div class="input-box">
						<span class="details">Address</span> <input type="text"
							name="address" placeholder="Enter the address" required />
					</div>

					<div class="input-box">
						<span class="details">City</span> <input type="text" name="city"
							placeholder="Enter the city" required />
					</div>

					<div class="input-box">
						<span class="details">State</span> <input type="text" name="state"
							placeholder="Enter the state" required />
					</div>

					<div class="input-box">
						<span class="details">Country</span> <input type="text"
							name="country" placeholder="Enter the country" required />
					</div>

					<div class="input-box">
						<span class="details">Payment Mode</span> <select class="input-box" id="paymentMode"
							name="paymentmethod" required style="padding: 10px;width:100%; background: #edf2ff; border: none;">
							<option class="active" value="default" selected disabled>Payment
								mode</option>
							<option value="cod">Cash on Delivery</option>
							<option value="online">Online Payment</option>
						</select>
					</div>
					
					<div class="input-box">
						<span class="details">TransactionId</span> <input id="transactionId" type="text"
							name="transId" placeholder="Enter transactionId" required />
					</div>
						
					<input type="submit" value="ConfirmOrder"
						style="background-color: #f5ce62; margin-left: 50%; margin-bottom: 1%; border: 2px solid var(- -primary-color); background-color: var(- -primary-color); cursor: pointer; padding: 1rem 2rem; width: 20%;">
				</div>
			</form>
		</div>
	</div>
	<script>
		document.getElementById("paymentMode").onchange = function() {
			document.getElementById("transactionId").disabled = (this.value == "cod" || this.value == "default");
		}
		document.getElementById("paymentMode").change(); //to trigger on load
	</script>

</body>
</html>