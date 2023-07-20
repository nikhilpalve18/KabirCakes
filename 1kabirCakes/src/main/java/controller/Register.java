package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.userDao;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String mobileNumber = request.getParameter("mobileNumber");
		String securityQuestion = request.getParameter("securityQuestion");
		String answer = request.getParameter("answer");
		String password = request.getParameter("pass");
		String address = "";
		String city = "";
		String state = "";
		String country = "";

		RequestDispatcher dispatcher = null;
		if (name == null || name == "") {
			dispatcher = request.getRequestDispatcher("register.jsp");
			request.setAttribute("status", "invalidusername");
			dispatcher.forward(request, response);
			return;
		}
		
		String regex = "^[\\w!#$%&'+/=?`{|}~^-]+(?:\\.[\\w!#$%&'+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		if (!matcher.matches()) {
			dispatcher = request.getRequestDispatcher("register.jsp");
			request.setAttribute("status", "invalidemail");
			dispatcher.forward(request, response);
			return;
		}
		
		if (email == null || email == "") {
			dispatcher = request.getRequestDispatcher("register.jsp");
			request.setAttribute("status", "invalidemail");
			dispatcher.forward(request, response);
			return;
		}

//		if (mobileNumber.length() != 10) {
//			dispatcher = request.getRequestDispatcher("register.jsp");
//			request.setAttribute("status", "Invalidmobilenumber");
//			dispatcher.forward(request, response);
//			return;
//		}

		System.out.println(mobileNumber.charAt(0));
		if (!((mobileNumber.charAt(0) == '9') || (mobileNumber.charAt(0) == '8') || (mobileNumber.charAt(0) == '7'))) {
			System.out.println("Hello I am mobile nums 1st char");
			dispatcher = request.getRequestDispatcher("register.jsp");
			request.setAttribute("status", "Invalidmobilenumber");
			dispatcher.forward(request, response);
			return;
		}

		if (answer == null || answer == "") {
			dispatcher = request.getRequestDispatcher("register.jsp");
			request.setAttribute("status", "invalidanswer");
			dispatcher.forward(request, response);
			return;
		}

		if (password == null || password == "") {
			dispatcher = request.getRequestDispatcher("register.jsp");
			request.setAttribute("status", "Invalidpassword");
			dispatcher.forward(request, response);
			return;
		}

		user u = new user(name, email, mobileNumber, securityQuestion, answer, password, address, city, state, country);
		List<user> lstreg = new ArrayList<user>();
		lstreg.add(u);
		userDao ud = new userDao();
		int i = ud.createUser(lstreg);
		HttpSession session = request.getSession();
		
		if (i > 0) {
			session.setAttribute("registerMessage", "Registeration successful");
			response.sendRedirect("register.jsp");
		} 
		else {
			session.setAttribute("registerMessage", "Something went wrong");
			response.sendRedirect("register.jsp");
		}

	}
}
