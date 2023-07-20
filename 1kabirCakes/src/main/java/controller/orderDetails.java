package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.user;

import java.io.IOException;
import java.util.List;

import dao.orderDetailsDao;

/**
 * Servlet implementation class orderDetails
 */
public class orderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		
		orderDetailsDao obj = new orderDetailsDao();
		List<user> lst = obj.getUserDetails(email);	
		user u = lst.get(0);
		System.out.println(u.getCity() + " " + u.getAddress() + " " + u.getMobileNumber());
		
		List<model.orderDetails> lst1 = obj.getOrderDetails(orderId);
		System.out.println("????" + lst1.size());
		
		HttpSession session = request.getSession();
		session.setAttribute("orderDetails", lst1);
		session.setAttribute("userDetails", lst);
		
		response.sendRedirect("orderDetails.jsp");
		
	}
}
