package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.cart;
import model.product;

import java.io.IOException;
import java.util.List;

import dao.*;

/**
 * Servlet implementation class getCart
 */
public class getCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("msg");
		String prodId = request.getParameter("id");
		String quantity = request.getParameter("quantity");
		
		HttpSession session = request.getSession();
		if(quantity != null && prodId!=null) {
			List<cart> lst =  getCartDao.incDecCart(email,prodId,quantity);
			if(lst.isEmpty() && quantity.equals("dec")) {
				List<cart> list =  getCartDao.getCartItems(email);	
				session.setAttribute("cartItems", list);
				response.sendRedirect("cart.jsp?msg=NotPossible");
			}
			else if(lst.isEmpty() && quantity.equals("inc")){
				List<cart> list =  getCartDao.getCartItems(email);	
				session.setAttribute("cartItems", list);
				response.sendRedirect("cart.jsp?msg=cannotIncrease");
			}
			else{
				session.setAttribute("cartItems", lst);
				response.sendRedirect("cart.jsp");
			}
		}
		
		else{			
			List<cart> lst =  getCartDao.getCartItems(email);	
			session.setAttribute("cartItems", lst);
			response.sendRedirect("cart.jsp");
		}
		
		
	}


}
