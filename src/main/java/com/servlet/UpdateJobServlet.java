package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.JobDAO;
import com.entity.Jobs;

@WebServlet("/update")
public class UpdateJobServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String title = req.getParameter("title");
			String location = req.getParameter("location");
			String category = req.getParameter("category");
			String status = req.getParameter("status");
			String desc = req.getParameter("desc");
			
			Jobs jobs = new Jobs();
			jobs.setId(id);
			jobs.setTitle(title);
			jobs.setCategory(category);
			jobs.setLocation(location);
			jobs.setDescription(desc);
			jobs.setStatus(status);
			
			HttpSession session = req.getSession();
			JobDAO dao = new JobDAO(DBConnect.getCon());
			boolean f = dao.updateJob(jobs);
			if (f) {
				session.setAttribute("succMsg", "Job update successfully");
				resp.sendRedirect("view_job.jsp");
			}else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("view_job.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
