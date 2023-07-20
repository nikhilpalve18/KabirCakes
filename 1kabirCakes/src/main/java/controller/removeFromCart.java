package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.cart;

import java.io.IOException;
import java.util.List;

import dao.getCartDao;

/**
 * Servlet implementation class removeFromCart
 */
public class removeFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("msg");
		String prodId = request.getParameter("id");
		
		HttpSession session = request.getSession();
		int i = getCartDao.removeFromCart(email, prodId);
		List<cart> lst =  getCartDao.getCartItems(email);	
		session.setAttribute("cartItems", lst);
		if(i>0) {
			response.sendRedirect("cart.jsp?msg=removed");
		}		
		else {	
			response.sendRedirect("cart.jsp?msg=notRemoved");
		}
		
	}

}
