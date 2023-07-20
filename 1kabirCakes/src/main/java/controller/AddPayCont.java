package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.cart;
import model.order;
import model.orderDetails;
import model.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.addressPayment;
import dao.getCartDao;
import dao.getOrderDetails;

/**
 * Servlet implementation class AddressPayment
 */
public class AddPayCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		String address = request.getParameter("address");		
		String city = request.getParameter("city");		
		String state = request.getParameter("state");		
		String country = request.getParameter("country");		
		String payMethod = request.getParameter("paymentmethod");		
		String transId = request.getParameter("transId");
		
		user u = new user();u.setEmail(email); u.setAddress(address);u.setCity(city);u.setState(state);u.setCountry(country);
		
		order o = new order();o.setPaymentMode(payMethod);o.setTransactionId(transId);
		
		List<user> userLst = new ArrayList<user>();
		userLst.add(u);
		
		List<order> orderLst = new ArrayList<order>();
		orderLst.add(o);
		
		addressPayment obj = new addressPayment();
		obj.insertAddress(userLst);
		int orderId = obj.insertOrder(email, orderLst);
		
 		// fetch data from cart
		List<cart> list =  getCartDao.getCartItems(email);
		
		// inserting the order details fetched from cart
		obj.insertOrderDetails(orderId,list);
		
		// empty the cart items
		getCartDao.emptyCart(email);
		
		List<orderDetails> detailsList = getOrderDetails.getDetails(orderId);
		session.setAttribute("orderDetails", detailsList);
		response.sendRedirect("bill.jsp");
		
	}
}
