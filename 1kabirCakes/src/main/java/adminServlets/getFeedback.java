package adminServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.contact;
import model.product;

import java.io.IOException;
import java.util.List;

import adminDao.getFeedbackDao;
import dao.getAllProducts;

/**
 * Servlet implementation class getFeedback
 */
public class getFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<contact> lst = getFeedbackDao.getMessages();
		HttpSession session = request.getSession();

		session.setAttribute("AllMessages", lst);
		response.sendRedirect("AdminReceivedMessages.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
