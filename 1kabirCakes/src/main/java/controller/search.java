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
import dao.searchProduct;

/**
 * Servlet implementation class search
 */
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchText = request.getParameter("searchText");
		String category = request.getParameter("category");
		
		List<product> lst =  searchProduct.search(searchText, category);
		product p = lst.get(0);
		System.out.println(p.getCategory());
		System.out.println(p.getImageFileName());
		
		HttpSession session = request.getSession();
		session.setAttribute("Allproducts", lst);
		
		if(p.getCategory().equals("minibites")) {
			response.sendRedirect("minibites.jsp");
		}
		else {			
			response.sendRedirect("cakes.jsp");
		}
	}

}
