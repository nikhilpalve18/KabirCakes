package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.product;

import java.io.IOException;

import dao.addToCartDao;

/**
 * Servlet implementation class addToCart
 */
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prodId = Integer.parseInt(request.getParameter("prodId"));
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		if(email == null) {
			response.sendRedirect("register.jsp");
		}
		else {			
			addToCartDao obj = new addToCartDao();
			int i = obj.insertIntoCart(prodId,email);
			if(i>0) {
				System.out.println("success");
				session.setAttribute("cartMsg", "Added successfully!");
				response.sendRedirect("cakes.jsp");
			}
			else {
				System.out.println("failed");
				session.setAttribute("cartMsg", "Something went wrong");
				response.sendRedirect("cakes.jsp");
			}
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
