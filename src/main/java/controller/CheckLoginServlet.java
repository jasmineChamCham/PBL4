package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.HostBO;
import Model.Bean.Host;

public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("_username");
		String password = request.getParameter("_password");
		HttpSession session = request.getSession();
		HostBO hostBO = new HostBO();
		String auth = hostBO.checkLogin(username, password);
		if (auth != null)
		{
			session.setAttribute("auth", auth);
			ArrayList<Host> hosts = hostBO.getHosts(auth);
			ArrayList<ArrayList<Double>> CPUutilizations = hostBO.getCPUutilization(auth);
			ArrayList<ArrayList<Double>> MemoryUtilizations = hostBO.getMemoryUtilization(auth);
			request.setAttribute("hosts", hosts);
			request.setAttribute("CPUutilizations", CPUutilizations);
			request.setAttribute("MemoryUtilizations", MemoryUtilizations);
			request.setAttribute("auth", auth);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect("page-failLogin-error.jsp");
		}
	}

}
