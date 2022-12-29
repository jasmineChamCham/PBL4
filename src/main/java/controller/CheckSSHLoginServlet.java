package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.HostBO;
import Model.BO.ProcessBO;
import Model.Bean.Host;
import Model.Bean.Process;

public class CheckSSHLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckSSHLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String host = request.getParameter("host");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		boolean isSSHConnected = ProcessBO.sshConnect(username, password, host);
		try 
		{
			if (isSSHConnected) 
			{
				List<Process> listProcesses = ProcessBO.getAllProcesses(username, password, host);
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("host", host);				
				session.setAttribute("listProcesses", listProcesses);
				RequestDispatcher dispatcher = request.getRequestDispatcher("display-processes.jsp");
				dispatcher.forward(request, response);
			} 
			else 
			{
				response.sendRedirect("page-failLogin-error.jsp");
			}

		} 
		catch (Exception e) 
		{
			response.sendRedirect("page-failLogin-error.jsp");
			e.printStackTrace();
		}
	}
}