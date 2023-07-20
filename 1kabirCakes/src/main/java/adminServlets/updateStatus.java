package adminServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.order;

import java.io.IOException;
import java.util.List;

import adminDao.getOrderDao;
import adminDao.updateStatusDao;

/**
 * Servlet implementation class updateStatus
 */
public class updateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status = request.getParameter("status");
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		System.out.println(status);
		System.out.println(orderId);

		updateStatusDao.updateStatus(orderId, status);
		status = "processing";
		HttpSession session = request.getSession();
		List<order> lst = getOrderDao.getAllOrders(status);

		session.setAttribute("allOrders", lst);
		response.sendRedirect("orders.jsp");
	}
}
