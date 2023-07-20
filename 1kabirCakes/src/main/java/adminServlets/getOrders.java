package adminServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.cart;
import model.order;

import java.io.IOException;
import java.util.List;

import adminDao.getOrderDao;
import dao.getCartDao;

/**
 * Servlet implementation class getOrders
 */
public class getOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getOrders() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status = request.getParameter("status"); // delivered
		HttpSession session = request.getSession();
		List<order> lst = getOrderDao.getAllOrders(status);
		session.setAttribute("allOrders", lst);
		
		if(status.equals("processing")) {			
			response.sendRedirect("orders.jsp");
		}
		else if(status.equals("cancelled")) {
			response.sendRedirect("cancelledOrders.jsp");
		}
		else {
			response.sendRedirect("deliveredOrders.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
