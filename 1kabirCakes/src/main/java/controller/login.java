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

import dao.searchUser;
import dao.userDao;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
	
		user u = new user();
		u.setEmail(email);
		u.setPassword(pass);
		
		List<user> lstreg = new ArrayList<user>();
		lstreg.add(u);	
		searchUser s = new searchUser();
		user u1 = s.search(lstreg);
		System.out.println(u1.getName());
		System.out.println(u1.getUserRole());

		HttpSession session = request.getSession();
		
		
		if(u1.getName() != null ) {
			if(u1.getUserRole() == 2) {				
				session.setAttribute("email", u1.getEmail());
				response.sendRedirect("home.jsp");
			}
			else {
				session.setAttribute("email", u1.getEmail());
				response.sendRedirect("adminHome.jsp");
			}
		}
		else {
			session.setAttribute("message", "Something went wrong");
			response.sendRedirect("login.jsp");
		}			
	}

}
