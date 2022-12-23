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
import Model.BO.UserBO;
import Model.Bean.Host;

public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangePasswordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("_password");
		String confirmPassword = request.getParameter("_confirmPassword");
		HttpSession session = request.getSession();	
		String auth = session.getAttribute("auth").toString();
		HostBO hostBO = new HostBO();
		if (!confirmPassword.equals(password)) 
		{
			request.setAttribute("mesg", "Password and confirm password do not match.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("change-password-error.jsp");
			dispatcher.forward(request, response);
		} 
		else 
		{	
			String mesg = UserBO.changePassword(auth, "1", password);
			if (mesg == null)
			{
				ArrayList<Host> hosts = hostBO.getHosts(auth);
				request.setAttribute("hosts", hosts);
				request.setAttribute("auth", auth);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				request.setAttribute("mesg", mesg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("change-password-error.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
