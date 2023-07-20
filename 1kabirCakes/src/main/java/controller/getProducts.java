package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.product;

import java.io.IOException;
import java.util.List;

import dao.getAllProducts;

/**
 * Servlet implementation class getProducts
 */
public class getProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		List<product> lst =  getAllProducts.getProducts(category);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("Allproducts", lst);
		if(category.equals("cakes")) {			
			response.sendRedirect("cakes.jsp");
		}
		else if(category.equals("adminView")) {
			response.sendRedirect("AdminAllProducts.jsp");
		}
		else {
			response.sendRedirect("minibites.jsp");			
		}
	}
}
