package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.contact;
import model.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.contactUsDao;
import dao.searchUser;

/**
 * Servlet implementation class login
 */
public class contactUs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String useremail = (String)session.getAttribute("email");
		
		if(useremail == null) {
			response.sendRedirect("register.jsp");
		}
		else {			
			String fullName = request.getParameter("fullName");
			String msgemail = request.getParameter("email");
			String msg = request.getParameter("message");
			
			contact c = new contact();
			c.setFullName(fullName);
			c.setEmail(msgemail);
			c.setMessage(msg);
			
			List<contact> lstreg = new ArrayList<contact>();
			lstreg.add(c);	
			contactUsDao obj = new contactUsDao() ;
			int i = obj.insertMsg(lstreg, useremail);
			
			if (i > 0) {
				session.setAttribute("message", "message sent");
				response.sendRedirect("Contact-Us.jsp");
			} else {
				session.setAttribute("message", "Something went wrong");
				response.sendRedirect("Contact-Us.jsp");
			}	
		}
		
	}

}
