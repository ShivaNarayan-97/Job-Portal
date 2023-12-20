package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email = req.getParameter("em");
			String password = req.getParameter("pwd");
			
			User u = new User();
			HttpSession session = req.getSession();
			
			if ("admin@gmail.com".equals(email) && "12345".equals(password)) {
				session.setAttribute("userobj", u);
				u.setRole("admin");
				resp.sendRedirect("admin.jsp");
			}else {
				UserDAO dao = new UserDAO(DBConnect.getCon());
				User user = dao.login(email, password);
				
				if (user != null) {
					session.setAttribute("userobj", user);
					resp.sendRedirect("home.jsp");
				}else {
					session.setAttribute("succMsg", "Invalid Email & Password");
					resp.sendRedirect("login.jsp");
				}
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
