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

/**
 * Servlet implementation class changePasswordServlet
 */
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String password = request.getParameter("_password");
		String confirmPassword = request.getParameter("_confirmPassword");
		HttpSession session = request.getSession();	
		String auth = session.getAttribute("auth").toString();
		HostBO hostBO = new HostBO();
		if (! confirmPassword.equals(password)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("page-error-change-password.jsp");
			dispatcher.forward(request, response);
		} else {	
			System.out.println(password);
			System.out.print(auth);
			int isSuccessful = UserBO.changePassword(auth, "1", password);
			ArrayList<Host> hosts = hostBO.getHosts(auth);
			request.setAttribute("hosts", hosts);
			request.setAttribute("auth", auth);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
