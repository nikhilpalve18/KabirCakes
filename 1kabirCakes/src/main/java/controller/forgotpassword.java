package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.resetpassword;
import dao.userDao;

/**
 * Servlet implementation class forgotpassword
 */
public class forgotpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Into the servlet");
		String email = request.getParameter("uemail");
		String mobileNumber = request.getParameter("mobileNumber");
		String securityQuestion = request.getParameter("securityQuestion");
		String answer = request.getParameter("answer");
		String password = request.getParameter("newPass");
		
		
		System.out.println(email + mobileNumber + securityQuestion + answer + password);
		
		HttpSession session = request.getSession();
		user u = new user(email, mobileNumber, securityQuestion, answer, password);
		List<user> lstreg = new ArrayList<user>();
		lstreg.add(u);
		resetpassword rp = new resetpassword();
		int i = rp.resetpass(lstreg);
		System.out.println(i);
		if(i>0) {
			session.setAttribute("resetpassmsg", "Password reset successfully");
			response.sendRedirect("login.jsp");
		}
		else {
			session.setAttribute("resetpassmsg", "Something went wrong");
			response.sendRedirect("login.jsp");
		}
	}

}
